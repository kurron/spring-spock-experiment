package org.kurron.work

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Implementation of Worker interface.
 */
class WorkerB implements Worker {

    private static final Logger logger = LoggerFactory.getLogger( WorkerB.class )

    private final Worker delegate

    WorkerB(Worker delegate) {
        this.delegate = delegate
    }

    @Override
    String doWork(int delay) {
        logger.debug( 'Waiting for {} milliseconds.', delay )
        Thread.sleep( delay )
        String results = delegate.doWork(delay)
        return results
    }
}
