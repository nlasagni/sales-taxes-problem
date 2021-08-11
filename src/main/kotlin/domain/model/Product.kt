package domain.model

import domain.model.exception.NameMustNotBeEmpty
import java.math.BigDecimal

/**
 * An Item that can be purchased.
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
data class Product(
    val id: ProductId,
    val name: String,
    val category: ProductCategory,
    val shelfPrice: BigDecimal,
    val imported: Boolean
) {
    init {
        if (name.isEmpty()) {
            throw NameMustNotBeEmpty()
        }
    }
}
