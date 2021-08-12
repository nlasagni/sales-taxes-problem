package domain.model

import domain.model.exception.NameMustNotBeEmpty

/**
 * A Product that can be purchased.
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
class Product(
    val id: ProductId,
    val name: String,
    val category: ProductCategory,
    val shelfPrice: Amount,
    val imported: Boolean
) {
    init {
        if (name.isEmpty()) {
            throw NameMustNotBeEmpty()
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Product) return false

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun toString(): String {
        return "Product(id=$id, name='$name', category=$category, shelfPrice=$shelfPrice, imported=$imported)"
    }
}
