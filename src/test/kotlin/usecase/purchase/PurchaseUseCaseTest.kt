package usecase.purchase

import domain.model.Product
import domain.model.ProductCategory
import domain.model.ProductId
import domain.service.TaxAmountCalculatorImpl
import domain.service.TaxRateProviderImpl
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import usecase.shared.UseCaseOutput
import usecase.shared.model.UseCaseError
import usecase.shared.model.UseCaseResponse
import java.math.BigDecimal

/**
 * Test of the [PurchaseUseCase].
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
class PurchaseUseCaseTest : FreeSpec({

    val taxRateProvider = TaxRateProviderImpl()
    val taxCalculator = TaxAmountCalculatorImpl(taxRateProvider)
    val fakeProductId = ProductId("1234")
    val books = Product(fakeProductId, "book", ProductCategory.BOOK, BigDecimal(2), false)
    val musicCD = Product(fakeProductId, "music CD", ProductCategory.MISCELLANEOUS, BigDecimal(1), false)
    val chocolateBar = Product(fakeProductId, "chocolate bar", ProductCategory.FOOD, BigDecimal(1), false)
    val purchaseItems = listOf(books, musicCD, chocolateBar)
    val totalSalesTaxes = BigDecimal(0.1)
    val totalPrice = BigDecimal(4.1)

    "The purchase use case should generate a response which contains correct items, taxes and total price" - {
        val purchaseUseCase = PurchaseUseCase(
            taxCalculator,
            object : UseCaseOutput<PurchaseResponse> {
                override fun handleResponse(response: UseCaseResponse<PurchaseResponse>) {
                    val purchaseResponse = response.response
                    purchaseResponse.receipt.purchasedProducts.size.shouldBe(purchaseItems.size)
                    purchaseResponse.receipt.totalSalesTaxes.shouldBe(totalSalesTaxes)
                    purchaseResponse.receipt.totalPrice.shouldBe(totalPrice)
                }

                override fun handleError(error: UseCaseError) {
                    // Not used for this test
                }
            }
        )
        val purchaseRequest = PurchaseRequest(purchaseItems)
        purchaseUseCase.execute(purchaseRequest)
    }
})
