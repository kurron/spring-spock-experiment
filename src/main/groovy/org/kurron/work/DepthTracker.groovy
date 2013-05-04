package org.kurron.work

import java.util.concurrent.atomic.AtomicInteger

/**
 * Created with IntelliJ IDEA.
 * User: ron
 * Date: 5/4/13
 * Time: 7:16 PM
 * To change this template use File | Settings | File Templates.
 */
class DepthTracker {
    private final ThreadLocal<AtomicInteger> depth = new ThreadLocal<>()

    DepthTracker() {
        depth.set( new AtomicInteger( 0 ) )
    }

    int depth() {
        return depth.get().get()
    }

    int push() {
        depth.get().incrementAndGet()
    }

    int pop() {
        depth.get().decrementAndGet()
    }
}
