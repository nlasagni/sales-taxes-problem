package domain.model

import java.util.*

/**
 * A [Product] that has been purchased.
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
class PurchasedProduct(val productId: UUID, val quantity: Int, val unitPriceWithTaxes: Amount)