package usecase.shared

import domain.model.PurchasedProduct

/**
 * Repository that persist information about purchased Products.
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
interface PurchasedProductRepository {

    /**
     * Adds the desired [purchasedProduct] to the repository.
     * @return The [PurchasedProduct] just added.
     */
    fun add(purchasedProduct: PurchasedProduct): PurchasedProduct

    /**
     * Finds all the [PurchasedProduct] of this repository.
     * @return The collection of [PurchasedProduct]s found.
     */
    fun findAll(): Collection<PurchasedProduct>

}