package usecase.shared

import domain.model.Product
import domain.model.ProductId

/**
 * Repository that persist information about Products.
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
interface ProductRepository {

    /**
     * Adds the desired [product] to the repository.
     * @return The [Product] just added.
     */
    fun add(product: Product): Product

    /**
     * Finds the [Product] with the specified [productId].
     * @return The [Product] found, if present.
     */
    fun findById(productId: ProductId): Product?

}