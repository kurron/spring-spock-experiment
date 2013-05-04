package org.kurron.spring.spock

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Groovy-based Spring context configuration.  Intended for integration testing.
 */
@Configuration
class SimpleIntegrationTestConfiguration {

    @Bean
    String expected() {
        return 'Devan'
    }
}
