package domain.model

import domain.model.exception.TaxRateMustBeGreaterThanZero

/**
 * Percentage at which a [Product] is taxed.
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
data class TaxRate(val percentage: Int) {

    init {
        if (percentage < 0) {
            throw TaxRateMustBeGreaterThanZero()
        }
    }

    /**
     * Operator that sums [other] tax rate to this tax rate.
     */
    operator fun plus(other: TaxRate): TaxRate {
        return TaxRate(percentage + other.percentage)
    }
}
