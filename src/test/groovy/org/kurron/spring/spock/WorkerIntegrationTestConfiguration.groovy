package org.kurron.spring.spock

import org.kurron.work.TimingAspect
import org.kurron.work.Worker
import org.kurron.work.WorkerA
import org.kurron.work.WorkerB
import org.kurron.work.WorkerC
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.EnableAspectJAutoProxy

/**
 * Groovy-based Spring context configuration.  Intended for integration testing.
 */
@Configuration
@EnableAspectJAutoProxy
class WorkerIntegrationTestConfiguration {

    @Bean
    Worker workerA() {
        return new WorkerA()
    }

    @Bean
    Worker workerB() {
        return new WorkerB( workerA() )
    }

    @Bean
    Worker workerC() {
        return new WorkerC( workerB() )
    }

    @Bean
    TimingAspect timingAspect()
    {
        return new TimingAspect()
    }
}
