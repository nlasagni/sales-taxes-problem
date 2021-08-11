package domain.service

import domain.model.Item

/**
 * Calculates tax amount and taxed prices of [Item]s.
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
class TaxCalculator(private val taxRateProvider: TaxRateProvider) {

    fun calculateTaxAmount(item: Item): Float {
        return (item.quantity * item.unitPrice * taxRateProvider.provideTaxRate(item)) / TaxRateProvider.TOTAL_TAX_RATE
    }

    fun calculateTaxedPrice(item: Item): Float {
        return totalPrice(item) + calculateTaxAmount(item)
    }

    private fun totalPrice(item: Item): Float {
        return item.unitPrice * item.quantity
    }
}
