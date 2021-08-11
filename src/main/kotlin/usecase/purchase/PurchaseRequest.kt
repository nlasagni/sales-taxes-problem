package usecase.purchase

import domain.model.Product

/**
 * Request coming from outer layer for purchasing [Product]s.
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
data class PurchaseRequest(
    val products: Collection<Product>
)
