package domain.model

import domain.model.exception.NameMustNotBeEmpty
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
    val shelfPrice: Price,
    val imported: Boolean
) {
    init {
        if (name.isEmpty()) {
            throw NameMustNotBeEmpty()
        }
    }

}
