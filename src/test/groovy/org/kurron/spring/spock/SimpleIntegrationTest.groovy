package org.kurron.spring.spock

import spock.lang.Specification

/**
 * Basic integration test.
 */
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
