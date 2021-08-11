package domain.service

import domain.model.Amount
import domain.model.Product
import domain.model.ProductCategory
import domain.model.ProductId
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

/**
 * @author Nicola Lasagni on 11/08/2021.
 */
class TaxRateProviderTest : FreeSpec({

    val fakeProductId = ProductId("1234")
    val taxRateProvider = TaxRateProviderImpl()

    "A TaxRateProvider should provide no tax rate for exempt items" - {
        val exemptItem = Product(fakeProductId, "Exempt item", ProductCategory.BOOK, Amount.of(1), false)
        taxRateProvider.provideTaxRate(exemptItem).shouldBe(TaxRateProviderImpl.NO_TAX_RATE)
    }

    "A TaxRateProvider should provide base sales tax rate for non-exempt items" - {
        val nonExemptItem = Product(
            fakeProductId,
            "Miscellaneous item",
            ProductCategory.MISCELLANEOUS,
            Amount.of(1),
            false
        )
        taxRateProvider.provideTaxRate(nonExemptItem).shouldBe(TaxRateProviderImpl.BASE_SALES_TAX_RATE)
    }

    "A TaxRateProvider should provide import duty tax rate for imported items" - {
        val importedItem = Product(
            fakeProductId,
            "Imported item",
            ProductCategory.BOOK,
            Amount.of(1),
            true
        )
        taxRateProvider.provideTaxRate(importedItem).shouldBe(TaxRateProviderImpl.IMPORT_DUTY_TAX_RATE)
    }

    "A TaxRateProvider should provide base sales plus import duty tax rate for non-exempt imported items" - {
        val nonExemptImportedTaxRate =
            TaxRateProviderImpl.BASE_SALES_TAX_RATE + TaxRateProviderImpl.IMPORT_DUTY_TAX_RATE
        val nonExemptImportedItem = Product(
            fakeProductId,
            "Non-exempt imported item",
            ProductCategory.MISCELLANEOUS,
            Amount.of(1),
            true
        )
        taxRateProvider.provideTaxRate(nonExemptImportedItem).shouldBe(nonExemptImportedTaxRate)
    }
})
