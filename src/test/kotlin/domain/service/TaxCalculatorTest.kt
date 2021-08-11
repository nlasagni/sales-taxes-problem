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
class TaxCalculatorTest : FreeSpec({

    val product = Product(
        ProductId("123"),
        "Test Item",
        ProductCategory.MISCELLANEOUS,
        Amount.of(1),
        true
    )
    val taxRateProvider = TaxRateProviderImpl()
    val taxCalculator = TaxAmountCalculatorImpl(taxRateProvider)
    val expectedTaxAmount = Amount(0.15)

    "A TaxCalculator should compute the tax amount for a given item" - {
        taxCalculator.calculateTaxAmount(product).shouldBe(expectedTaxAmount)
    }
})
