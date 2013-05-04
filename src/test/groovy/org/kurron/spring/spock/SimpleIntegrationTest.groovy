package org.kurron.spring.spock

import org.springframework.test.context.ContextConfiguration

/**
 * Basic integration test.
 */
@ContextConfiguration( "classpath:/org/kurron/spring/spock/SimpleIntegrationTest-context.xml" )
class SimpleIntegrationTest extends AbstractIntegrationTest {

    def 'bob'() {
        given:
        String sut = 'bob'

        when:
        String upper = sut.toUpperCase()

        then:
        assert upper.equals( 'BOB' )
    }
}
