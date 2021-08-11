package adapter.repository

import domain.model.Product
import domain.model.ProductId
import usecase.shared.ProductRepository

/**
 * A [ProductRepository] that stores information in application memory.
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
class InMemoryProductRepository : ProductRepository {

    private val inMemoryStorage: MutableMap<ProductId, Product> = mutableMapOf()

    override fun add(product: Product): Product {
        val id = product.id
        inMemoryStorage[id] = product
        return product
    }

    override fun findById(productId: ProductId): Product? {
        return inMemoryStorage[productId]
    }
}
