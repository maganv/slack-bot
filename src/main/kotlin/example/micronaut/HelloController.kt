package example.micronaut

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import java.util.UUID
import java.util.concurrent.ConcurrentHashMap

@Controller("/hello")
class HelloController {
    @Get
    @Produces(MediaType.TEXT_PLAIN)
    fun index(): String {
        return "Hello World";
    }
}


@Controller("/products")
class ProductController {
    private val inMemoryDatabase = ConcurrentHashMap<String, Product>()
    @Get
    fun index(): List<Product> {
        return inMemoryDatabase.elements().toList()
    }

    @Post
    fun create(@Body product: Product) {
        inMemoryDatabase[product.key] = product
    }
}

data class Product(val key: String, val name: String)
