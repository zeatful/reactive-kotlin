package bootiful.kotlin.route

import bootiful.kotlin.handler.CustomerHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.*

@Configuration
class ApiRoutes(private val handler: CustomerHandler) {
    @Bean
    fun apiRouter() = coRouter {
        (accept(MediaType.APPLICATION_JSON) and "/api").nest {
            GET("/customers", handler::findAll)
            GET("/customers/{id}", handler::findById)
            POST("/customers", handler::save)
            DELETE("/customers/{id}", handler::delete)
        }
    }
}