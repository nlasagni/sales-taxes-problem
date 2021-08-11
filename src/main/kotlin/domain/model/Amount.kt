package domain.model

import domain.model.exception.PriceMustBeGreaterThanZero

/**
 * The price of an [Product].
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
data class Amount(val value: Double) {
    init {
        if (value <= 0) {
            throw PriceMustBeGreaterThanZero()
        }
    }
}