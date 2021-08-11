package domain.service

import domain.model.Product
import java.math.BigDecimal

/**
 * @author Nicola Lasagni on 11/08/2021.
 */
class TaxAmountCalculatorImpl(private val taxRateProvider: TaxRateProviderImpl) : TaxAmountCalculator {

    override fun calculateTaxAmount(product: Product): BigDecimal {
        val shelfPriceDouble = product.shelfPrice.toDouble()
        val providedTaxRate = taxRateProvider.provideTaxRate(product)
        return BigDecimal.valueOf(
            (shelfPriceDouble * providedTaxRate.percentage) / TaxRateProviderImpl.TOTAL_TAX_RATE.percentage
        )
    }
}
