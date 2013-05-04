package org.kurron.spring.spock

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration

/**
 * Basic integration test.
 */
@ContextConfiguration( classes = SimpleIntegrationTestConfiguration.class  )
class SimpleIntegrationTest extends AbstractIntegrationTest {

    private static final Logger logger = LoggerFactory.getLogger( SimpleIntegrationTest.class )

    @Autowired
    String expected

    def 'this can never pass because we generate random strings each run'() {
        given:
        String sut = Integer.toHexString( generator.nextInt( Integer.MAX_VALUE ) ).toUpperCase()
        logger.debug( 'sut = {}', sut )

        when:
        String upper = sut.toUpperCase()
        logger.debug( 'upper = {}', upper )

        then:
        assert upper.equals( expected )
    }
}
