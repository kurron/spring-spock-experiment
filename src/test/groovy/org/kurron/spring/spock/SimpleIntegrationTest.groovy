package org.kurron.spring.spock

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration

/**
 * Basic integration test.
 */
@ContextConfiguration( "classpath:/org/kurron/spring/spock/SimpleIntegrationTest-context.xml" )
class SimpleIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    Random generator

    def 'bob'() {
        given:
        String sut = Integer.toHexString( generator.nextInt( Integer.MAX_VALUE ) ).toUpperCase()

        when:
        String upper = sut.toUpperCase()

        then:
        assert upper.equals( 'BOB' )
    }
}
