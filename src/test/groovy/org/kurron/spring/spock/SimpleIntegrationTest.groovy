package org.kurron.spring.spock
/**
 * Basic integration test.
 */
class SimpleIntegrationTest extends AbstractIntegrationTest {

    def 'bob'() {
        given:
        String sut = Integer.toHexString( generator.nextInt( Integer.MAX_VALUE ) ).toUpperCase()

        when:
        String upper = sut.toUpperCase()

        then:
        assert upper.equals( 'BOB' )
    }
}
