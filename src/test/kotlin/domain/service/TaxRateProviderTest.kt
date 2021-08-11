package domain.service

import domain.model.Category
import domain.model.Item
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

/**
 * @author Nicola Lasagni on 11/08/2021.
 */
class TaxRateProviderTest : FreeSpec({

    val taxRateProvider = TaxRateProvider()

    "A TaxRateProvider should provide no tax rate for exempt items" - {
        val exemptItem = Item("Exempt item", Category.BOOK, 1, 1f, false)
        taxRateProvider.provideTaxRate(exemptItem).shouldBe(TaxRateProvider.NO_TAX_RATE)
    }

    "A TaxRateProvider should provide base sales tax rate for non-exempt items" - {
        val nonExemptItem = Item(
            "Miscellaneous item",
            Category.MISCELLANEOUS,
            1,
            1f,
            false
        )
        taxRateProvider.provideTaxRate(nonExemptItem).shouldBe(TaxRateProvider.BASE_SALES_TAX_RATE)
    }

    "A TaxRateProvider should provide import duty tax rate for imported items" - {
        val importedItem = Item(
            "Imported item",
            Category.BOOK,
            1,
            1f,
            true
        )
        taxRateProvider.provideTaxRate(importedItem).shouldBe(TaxRateProvider.IMPORT_DUTY_TAX_RATE)
    }

    "A TaxRateProvider should provide base sales plus import duty tax rate for non-exempt imported items" - {
        val nonExemptImportedTaxRate =
            TaxRateProvider.BASE_SALES_TAX_RATE + TaxRateProvider.IMPORT_DUTY_TAX_RATE
        val nonExemptImportedItem = Item(
            "Non-exempt imported item",
            Category.MISCELLANEOUS,
            1,
            1f,
            true
        )
        taxRateProvider.provideTaxRate(nonExemptImportedItem).shouldBe(nonExemptImportedTaxRate)
    }
})
