package org.kurron.spring.spock

import org.kurron.work.Worker
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.test.context.ContextConfiguration

import javax.annotation.Resource

/**
 * Basic integration test.
 */
@ContextConfiguration( classes = WorkerIntegrationTestConfiguration.class  )
class WorkerIntegrationTest extends AbstractIntegrationTest {

    private static final Logger logger = LoggerFactory.getLogger( WorkerIntegrationTest.class )

    @Resource( name = 'workerC' )
    Worker sut

    def 'bob'() {
        given:
        assert sut != null

        when:
        String results = sut.doWork( generator.nextInt( 10000 ) )

        then:
        logger.debug( 'results = {}', results )
    }
}
