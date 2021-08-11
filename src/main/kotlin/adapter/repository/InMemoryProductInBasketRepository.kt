package adapter.repository

import domain.model.ProductInBasket
import usecase.shared.ProductInBasketRepository

/**
 * A [ProductInBasketRepository] that stores information in application memory.
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
class InMemoryProductInBasketRepository : ProductInBasketRepository {

    private var inMemoryStorage = mutableListOf<ProductInBasket>()

    override fun add(productInBasket: ProductInBasket): ProductInBasket {
        inMemoryStorage.add(productInBasket)
        return productInBasket
    }

    override fun findAll(): Collection<ProductInBasket> {
        return inMemoryStorage
    }
}
