package domain.service

import domain.model.Category
import domain.model.Item
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

/**
 * @author Nicola Lasagni on 11/08/2021.
 */
class TaxCalculatorTest : FreeSpec({

    val item = Item(
        "Test Item",
        Category.MISCELLANEOUS,
        1,
        1f,
        true
    )
    val taxRateProvider = TaxRateProvider()
    val taxCalculator = TaxCalculator(taxRateProvider)
    val expectedTaxAmount = 0.15f

    "A TaxCalculator should compute the tax amount for a given item" - {
        taxCalculator.calculateTaxAmount(item).shouldBe(expectedTaxAmount)
    }
    "A TaxCalculator should compute the taxed price for a given item" - {
        val expectedTaxedPrice = item.unitPrice.plus(expectedTaxAmount)
        taxCalculator.calculateTaxedPrice(item).shouldBe(expectedTaxedPrice)
    }
})
