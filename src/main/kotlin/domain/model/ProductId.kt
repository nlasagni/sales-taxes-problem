package domain.model

import domain.model.exception.ProductIdMissing

/**
 * The unique identifier of a [Product].
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
data class ProductId(private val value: String) {

    init {
        if (value.isEmpty()) {
            throw ProductIdMissing()
        }
    }
}
