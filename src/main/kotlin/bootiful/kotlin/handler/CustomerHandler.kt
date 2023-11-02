package bootiful.kotlin.handler

import bootiful.kotlin.model.Customer
import bootiful.kotlin.repository.CustomerRepository
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyToMono
import reactor.core.publisher.Mono

@Component
class CustomerHandler(private val customerRepository: CustomerRepository) {

//    fun setCustomer(request: ServerRequest): Mono<ServerResponse> {
//        return request.bodyToMono(Customer::class.java).
//    }
}