package usecase.purchase

import adapter.repository.InMemoryProductInBasketRepository
import adapter.repository.InMemoryProductRepository
import domain.model.Amount
import domain.model.Product
import domain.model.ProductCategory
import domain.model.ProductId
import domain.model.ProductInBasket
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import usecase.shared.UseCaseOutput

/**
 * Test of the [PurchaseUseCase].
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
class PurchaseUseCaseTest : FreeSpec({

    val productRepository = InMemoryProductRepository()
    val productInBasketRepository = InMemoryProductInBasketRepository()
    val book = Product(ProductId("1"), "Book", ProductCategory.BOOK, Amount.of(2), false)
    val musicCD = Product(ProductId("2"), "Music CD", ProductCategory.MISCELLANEOUS, Amount.of(1), false)
    val chocolateBar = Product(ProductId("3"), "Chocolate bar", ProductCategory.FOOD, Amount.of(1), false)
    val booksInBasket = ProductInBasket(ProductId("1"), 2, Amount.of(2))
    val musicCDInBasket = ProductInBasket(ProductId("2"), 1, Amount.of(1))
    val chocolateBarInBasket = ProductInBasket(ProductId("3"), 1, Amount.of(1))
    val productsInBasket = listOf(booksInBasket, musicCDInBasket, chocolateBarInBasket)
    val totalSalesTaxes = Amount(4.0)
    val totalPrice = Amount(10.0)

    beforeAny {
        productRepository.add(book)
        productRepository.add(musicCD)
        productRepository.add(chocolateBar)
        productInBasketRepository.add(booksInBasket)
        productInBasketRepository.add(musicCDInBasket)
        productInBasketRepository.add(chocolateBarInBasket)
    }

    "The purchase use case should generate a response which contains correct items, taxes and total price" - {
        val purchaseUseCase = PurchaseUseCase(
            productRepository,
            productInBasketRepository,
            object : UseCaseOutput<PurchaseResponse> {
                override fun handleResponse(response: PurchaseResponse) {
                    response.receipt.productInBaskets.size.shouldBe(productsInBasket.size)
                    response.receipt.totalSalesTaxes.shouldBe(totalSalesTaxes)
                    response.receipt.totalPrice.shouldBe(totalPrice)
                }
            }
        )
        purchaseUseCase.execute(PurchaseRequest())
    }
})
