package domain.model

import domain.model.exception.QuantityMustBeGreaterThanZero

/**
 * A [Product] that has been added to basket.
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
class ProductInBasket(
    val productId: ProductId,
    val quantity: Int,
    val taxesAmount: Amount
) {
    init {
        if (quantity <= 0) {
            throw QuantityMustBeGreaterThanZero()
        }
    }
}
