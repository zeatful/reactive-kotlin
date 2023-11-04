package bootiful.kotlin.handler

import bootiful.kotlin.model.Customer
import bootiful.kotlin.repository.CustomerRepository
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Controller
import org.springframework.web.reactive.function.server.*
import org.springframework.web.reactive.function.server.ServerResponse.ok

@Controller
class CustomerHandler(private val repository: CustomerRepository) {

    suspend fun findById(req: ServerRequest): ServerResponse {
        val id = req.pathVariable("id").toInt()
        val customer = repository.findById(id) ?: throw NotFoundException()
        return ok().bodyValueAndAwait(customer)
    }

    suspend fun findAll(req: ServerRequest): ServerResponse =
        ok().bodyAndAwait(repository.findAll())

    suspend fun save(req: ServerRequest): ServerResponse {
        val customer = req.awaitBody<Customer>()
        return ok().bodyValueAndAwait(repository.save(customer))
    }

    suspend fun delete(req: ServerRequest): ServerResponse {
        val id = req.pathVariable("id").toInt()
        return ok().bodyValueAndAwait(repository.deleteById(id))
    }
}