package org.kurron.work

/**
 * Silly interface that I can write an aspect against.
 */
public interface Worker {
    /**
     * Execute the job.
     * @param delay how long to wait, in milliseconds, before returning.
     * @return the results of the work.
     */
    String doWork( int delay )
}
