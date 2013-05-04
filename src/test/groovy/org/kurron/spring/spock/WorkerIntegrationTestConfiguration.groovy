package org.kurron.spring.spock

import org.kurron.work.WorkerA
import org.kurron.work.WorkerB
import org.kurron.work.WorkerC
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Groovy-based Spring context configuration.  Intended for integration testing.
 */
@Configuration
class WorkerIntegrationTestConfiguration {

    @Bean
    WorkerA workerA() {
        return new WorkerA()
    }

    @Bean
    WorkerB workerB() {
        return new WorkerB( workerA() )
    }

    @Bean
    WorkerC workerC() {
        return new WorkerC( workerB() )
    }
}
