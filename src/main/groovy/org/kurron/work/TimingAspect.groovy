package org.kurron.work

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.slf4j.profiler.Profiler
import org.slf4j.profiler.ProfilerRegistry

/**
 * Manipulates the slf4j profilers so we can get basic timing results.
 */
@Aspect
class TimingAspect {

    private static final Logger logger = LoggerFactory.getLogger( TimingAspect.class )
    private static final DepthTracker depthTracker = new DepthTracker()

    @Pointcut( "execution(* org.kurron.work.Worker.*(..))" )
    private void workerMethods() {}

    @Around( "workerMethods()" )
    public def doSomething( ProceedingJoinPoint joinPoint )
    {
        int current = depthTracker.push()
        ProfilerRegistry profilerRegistry = ProfilerRegistry.getThreadContextInstance()
        if ( 1 == current )  {
            Profiler profiler = new Profiler( "DEMO" )
            profiler.registerWith( profilerRegistry )
            profiler.logger = logger
            profiler.start( joinPoint.target.getClass().name + '.' + joinPoint.signature.name )
        }
        else {
            Profiler profiler = profilerRegistry.get("DEMO")
            profiler.startNested( joinPoint.target.getClass().name + '.' + joinPoint.signature.name )
        }
        def results = joinPoint.proceed()
        current = depthTracker.pop()
        if ( 0 == current ) {
            Profiler profiler = profilerRegistry.get("DEMO")
            profiler.stop().log()
        }
        return results
    }
}
