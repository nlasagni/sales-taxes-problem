package domain.model

import domain.model.exception.TaxRateMustBeGreaterThanZero

/**
 * Percentage at which an [Item] is taxed.
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
data class TaxRate(val amount: Int) {

    init {
        if (amount <= 0) {
            throw TaxRateMustBeGreaterThanZero()
        }
    }

    operator fun plus(otherTaxRate: TaxRate): TaxRate {
        return TaxRate(amount + otherTaxRate.amount)
    }

}