package domain.model

/**
 * @author Nicola Lasagni on 12/08/2021.
 */
class ProductInReceipt(
    val name: String,
    val quantity: Int,
    val taxesAmount: Amount,
    val shelfPriceIncludingTaxes: Amount
)
