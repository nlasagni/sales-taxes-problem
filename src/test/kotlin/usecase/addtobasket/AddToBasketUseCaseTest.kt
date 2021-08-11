package usecase.addtobasket

import adapter.repository.InMemoryProductInBasketRepository
import adapter.repository.InMemoryProductRepository
import domain.model.Amount
import domain.model.Product
import domain.model.ProductCategory
import domain.model.ProductId
import domain.service.TaxAmountCalculatorImpl
import domain.service.TaxRateProviderImpl
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows

/**
 * @author Nicola Lasagni on 11/08/2021.
 */
class AddToBasketUseCaseTest : FreeSpec({

    val taxProvider = TaxRateProviderImpl()
    val taxCalculator = TaxAmountCalculatorImpl(taxProvider)
    val productRepository = InMemoryProductRepository()
    val productInBasketRepository = InMemoryProductInBasketRepository()
    val addToBasketUseCase = AddToBasketUseCase(
        taxCalculator,
        productRepository,
        productInBasketRepository,
        MockedUseCaseOutput()
    )
    val fakeId = ProductId("1234")

    "The AddToBasketUseCase should throw exception if the product is not found" - {
        val request = AddToBasketRequest(fakeId, 1)
        assertThrows<ProductNotFound> { addToBasketUseCase.execute(request) }
    }

    "The AddToBasketUseCase add a product to the basket with the right quantity and amounts" - {
        productRepository.add(
            Product(fakeId, "book", ProductCategory.BOOK, Amount.of(1), false)
        )
        val quantity = 2
        val request = AddToBasketRequest(fakeId, quantity)
        addToBasketUseCase.execute(request)
        val productInBasket = productInBasketRepository.findAll().first()
        productInBasket.productId.shouldBe(fakeId)
        productInBasket.quantity.shouldBe(quantity)
    }
})
