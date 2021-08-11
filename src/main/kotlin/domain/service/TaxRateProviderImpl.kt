package domain.service

import domain.model.ProductCategory
import domain.model.Product
import domain.model.TaxRate

/**
 * @author Nicola Lasagni on 11/08/2021.
 */
class TaxRateProviderImpl : TaxRateProvider {

    companion object {
        val NO_TAX_RATE = TaxRate(0)
        val TOTAL_TAX_RATE = TaxRate(100)
        val BASE_SALES_TAX_RATE = TaxRate(10)
        val IMPORT_DUTY_TAX_RATE = TaxRate(5)
    }

    override fun provideTaxRate(product: Product): TaxRate {
        return getBaseSalesTaxRate(product) + getImportedTaxRate(product)
    }

    private fun getBaseSalesTaxRate(product: Product): TaxRate {
        return if (product.category == ProductCategory.MISCELLANEOUS) BASE_SALES_TAX_RATE else NO_TAX_RATE
    }

    private fun getImportedTaxRate(product: Product): TaxRate {
        return if (product.imported) IMPORT_DUTY_TAX_RATE else NO_TAX_RATE
    }
}
