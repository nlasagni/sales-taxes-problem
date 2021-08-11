package domain.service

import domain.model.Category
import domain.model.Item

/**
 * Provides tax rate based on [Item].
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
class TaxRateProvider {

    companion object {
        const val NO_TAX_RATE = 0
        const val TOTAL_TAX_RATE = 100
        const val BASE_SALES_TAX_RATE = 10
        const val IMPORT_DUTY_TAX_RATE = 5
    }

    fun provideTaxRate(item: Item): Int {
        return getBaseSalesTaxRate(item) + getImportedTaxRate(item)
    }

    private fun getBaseSalesTaxRate(item: Item): Int {
        return if (item.category == Category.MISCELLANEOUS) BASE_SALES_TAX_RATE else NO_TAX_RATE
    }

    private fun getImportedTaxRate(item: Item): Int {
        return if (item.imported) IMPORT_DUTY_TAX_RATE else NO_TAX_RATE
    }
}
