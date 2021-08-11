package usecase.purchase

import domain.model.Category
import domain.model.Item
import domain.service.TaxCalculator
import domain.service.TaxRateProvider
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import usecase.shared.UseCaseOutput
import usecase.shared.model.UseCaseError
import usecase.shared.model.UseCaseResponse

/**
 * Test of the [PurchaseUseCase].
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
class PurchaseUseCaseTest : FreeSpec({

    val taxRateProvider = TaxRateProvider()
    val taxCalculator = TaxCalculator(taxRateProvider)
    val books = Item("book", Category.BOOK, 2, 1f, false)
    val musicCD = Item("music CD", Category.MISCELLANEOUS, 1, 1f, false)
    val chocolateBar = Item("chocolate bar", Category.FOOD, 1, 1f, false)
    val purchaseItems = listOf(books, musicCD, chocolateBar)
    val totalSalesTaxes = 0.1f
    val totalPrice = 4.1f

    "The purchase use case should generate a response which contains correct items, taxes and total price" - {
        val purchaseUseCase = PurchaseUseCase(
            taxCalculator,
            object : UseCaseOutput<PurchaseResponse> {
                override fun handleResponse(response: UseCaseResponse<PurchaseResponse>) {
                    val purchaseResponse = response.response
                    purchaseResponse.items.size.shouldBe(purchaseItems.size)
                    purchaseResponse.salesTaxesAmount.shouldBe(totalSalesTaxes)
                    purchaseResponse.totalPrice.shouldBe(totalPrice)
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
