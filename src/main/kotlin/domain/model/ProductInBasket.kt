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

    override fun toString(): String {
        return "ProductInBasket(productId=$productId, quantity=$quantity, taxesAmount=$taxesAmount)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ProductInBasket) return false

        if (productId != other.productId) return false

        return true
    }

    override fun hashCode(): Int {
        return productId.hashCode()
    }
}
