package domain.service

import domain.model.Amount
import domain.model.Product

/**
 * @author Nicola Lasagni on 11/08/2021.
 */
class TaxAmountCalculatorImpl(
    private val taxRateProvider: TaxRateProviderImpl,
    private val amountRoundingStrategy: AmountRoundingStrategy
) : TaxAmountCalculator {

    override fun calculateTaxAmount(product: Product): Amount {
        val providedTaxRate = taxRateProvider.provideTaxRate(product)
        val taxAmount =
            (product.shelfPrice * providedTaxRate.percentage) / TaxRateProviderImpl.TOTAL_TAX_RATE.percentage
        return amountRoundingStrategy.round(taxAmount)
    }
}
