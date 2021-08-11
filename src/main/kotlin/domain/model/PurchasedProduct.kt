package domain.model

import java.math.BigDecimal
import java.util.*

/**
 * A [Product] that has been purchased.
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
class PurchasedProduct(val productId: ProductId, val quantity: Int, val unitPriceWithTaxes: BigDecimal)