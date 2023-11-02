package bootiful.kotlin.route

import bootiful.kotlin.repository.CustomerRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.*

@Configuration
class CustomerRoute(private val customerRepository: CustomerRepository) {
    @Bean
    fun route() = coRouter {
        GET("/customers") {
            ServerResponse.ok().bodyAndAwait(customerRepository.findAll())
        }

        GET("/customers/{id}") {
            val id = it.pathVariable("id").toInt()
            val result = customerRepository.findById(id)
            if (result != null)
                ServerResponse.ok().bodyValueAndAwait(result)
            else
                ServerResponse.notFound().buildAndAwait()
        }

        accept(MediaType.APPLICATION_JSON).nest {
            POST("/customers").invoke(customerRepository::save)
        }

    }
}