package domain.model

/**
 * A [Product] that has been added to basket.
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
class ProductInBasket(val productId: ProductId, val quantity: Int, val unitPriceWithTaxes: Amount)
