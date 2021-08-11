package usecase.shared

import domain.model.ProductInBasket

/**
 * Repository that persist information about Products in basket.
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
interface ProductInBasketRepository {

    /**
     * Adds the desired [productInBasket] to the repository.
     * @return The [ProductInBasket] just added.
     */
    fun add(productInBasket: ProductInBasket): ProductInBasket

    /**
     * Finds all the [ProductInBasket] of this repository.
     * @return The collection of [ProductInBasket]s found.
     */
    fun findAll(): Collection<ProductInBasket>
}
