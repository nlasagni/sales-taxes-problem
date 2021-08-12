package domain.model

/**
 * A [Product] inside a receipt.
 *
 * @author Nicola Lasagni on 12/08/2021.
 */
class ProductInReceipt(
    val name: String,
    val quantity: Int,
    val taxesAmount: Amount,
    val shelfPriceIncludingTaxes: Amount
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ProductInReceipt) return false

        if (name != other.name) return false
        if (quantity != other.quantity) return false
        if (taxesAmount != other.taxesAmount) return false
        if (shelfPriceIncludingTaxes != other.shelfPriceIncludingTaxes) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + quantity
        result = 31 * result + taxesAmount.hashCode()
        result = 31 * result + shelfPriceIncludingTaxes.hashCode()
        return result
    }

    override fun toString(): String {
        return "ProductInReceipt(" +
            "name='$name', " +
            "quantity=$quantity, " +
            "taxesAmount=$taxesAmount, " +
            "shelfPriceIncludingTaxes=$shelfPriceIncludingTaxes)"
    }
}
