package usecase.addtobasket

import domain.model.Product
import domain.model.ProductId

/**
 * Request coming from outer layer for adding [Product]s to the basket.
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
data class AddToBasketRequest(val productId: ProductId, val quantity: Int)
