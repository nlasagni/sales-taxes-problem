package domain.model

/**
 * The receipt related to the [ProductInBasket]s chosen.
 *
 * It includes the total of sales taxes applied and the total price of the purchase.
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
class Receipt(
    val productInBaskets: Collection<ProductInReceipt>,
    val totalSalesTaxes: Amount,
    val totalPrice: Amount
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Receipt) return false

        if (productInBaskets != other.productInBaskets) return false
        if (totalSalesTaxes != other.totalSalesTaxes) return false
        if (totalPrice != other.totalPrice) return false

        return true
    }

    override fun hashCode(): Int {
        var result = productInBaskets.hashCode()
        result = 31 * result + totalSalesTaxes.hashCode()
        result = 31 * result + totalPrice.hashCode()
        return result
    }

    override fun toString(): String {
        return "Receipt(productInBaskets=$productInBaskets, totalSalesTaxes=$totalSalesTaxes, totalPrice=$totalPrice)"
    }
}
