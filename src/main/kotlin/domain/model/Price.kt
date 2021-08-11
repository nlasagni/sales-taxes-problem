package domain.model

import domain.model.exception.PriceMustBeGreaterThanZero

/**
 * The price of an [Item].
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
data class Price(val amount: Double) {
    init {
        if (amount <= 0) {
            throw PriceMustBeGreaterThanZero()
        }
    }
}