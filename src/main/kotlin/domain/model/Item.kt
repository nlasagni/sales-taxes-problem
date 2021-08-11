package domain.model

/**
 * An Item that can be purchased.
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
data class Item(
    val name: String,
    val category: Category,
    val quantity: Int,
    val unitPrice: Float,
    val imported: Boolean
)
