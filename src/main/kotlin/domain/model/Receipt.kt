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
)
