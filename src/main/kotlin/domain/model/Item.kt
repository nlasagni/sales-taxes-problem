package domain.model

import domain.model.exception.NameMustNotBeEmpty
import domain.model.exception.PriceMustBeGreaterThanZero
import java.util.*

/**
 * An Item that can be purchased.
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
data class Item(
    val id: UUID,
    val name: String,
    val category: Category,
    val shelfPrice: Float,
    val imported: Boolean
) {
    init {
        if (name.isEmpty()) {
            throw NameMustNotBeEmpty()
        }
        if (shelfPrice <= 0f) {
            throw PriceMustBeGreaterThanZero()
        }
    }

}
