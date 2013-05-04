package org.kurron.spring.spock

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * Base class for Spock-based integration tests.
 */
@ContextConfiguration( classes = AbstractIntegrationTestConfiguration.class )
abstract class AbstractIntegrationTest extends Specification {

    @Autowired
    protected Random generator

}
