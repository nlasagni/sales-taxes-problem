package adapter.repository

import domain.model.PurchasedProduct
import usecase.shared.PurchasedProductRepository

/**
 * A [PurchasedProductRepository] that stores information in application memory.
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
class InMemoryPurchasedProductRepository : PurchasedProductRepository {

    private var inMemoryStorage = mutableListOf<PurchasedProduct>()

    override fun add(purchasedProduct: PurchasedProduct): PurchasedProduct {
        inMemoryStorage.add(purchasedProduct)
        return purchasedProduct
    }

    override fun findAll(): Collection<PurchasedProduct> {
        return inMemoryStorage
    }
}