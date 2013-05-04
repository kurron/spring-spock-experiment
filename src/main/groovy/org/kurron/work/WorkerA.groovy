package org.kurron.work

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Implementation of Worker interface.
 */
class WorkerA implements Worker {
    private static final Logger logger = LoggerFactory.getLogger( WorkerA.class )

    @Override
    String doWork(int delay) {
        logger.debug( 'Waiting for {} milliseconds.', delay )
        return 'A'
    }
}
