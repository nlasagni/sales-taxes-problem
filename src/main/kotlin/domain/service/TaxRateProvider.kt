package domain.service

import domain.model.Category
import domain.model.Item

/**
 * Provides tax rate based on [Item].
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
class TaxRateProvider {

    private val noTaxRate = 0
    private val baseSalesTaxRate = 10
    private val importDuty = 5

    fun provideTaxRate(item: Item): Int {
        return getBaseSalesTaxRate(item) + getImportedTaxRate(item)
    }

    private fun getBaseSalesTaxRate(item: Item): Int {
        return if (item.category == Category.MISCELLANEOUS) baseSalesTaxRate else noTaxRate
    }

    private fun getImportedTaxRate(item: Item): Int {
        return if (item.imported) importDuty else noTaxRate
    }
}
