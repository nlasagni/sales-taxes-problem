package configuration

import adapter.presenter.BasketPresenter
import adapter.presenter.PresenterOutput
import adapter.presenter.ReceiptPresenter
import adapter.repository.InMemoryProductInBasketRepository
import adapter.repository.InMemoryProductRepository
import domain.service.RoundUpToNearestOneTwentiethStrategy
import domain.service.TaxAmountCalculatorImpl
import domain.service.TaxRateProviderImpl
import usecase.addtobasket.AddToBasketRequest
import usecase.addtobasket.AddToBasketUseCase
import usecase.purchase.PurchaseRequest
import usecase.purchase.PurchaseUseCase
import usecase.shared.UseCaseInput

/**
 * Simple configuration class that prepares the application components and inserts some mock data.
 *
 * @author Nicola Lasagni on 12/08/2021.
 */
class SalesTaxesConfiguration {

    private val taxProvider = TaxRateProviderImpl()
    val amountRoundingStrategy = RoundUpToNearestOneTwentiethStrategy()
    private val taxCalculator = TaxAmountCalculatorImpl(taxProvider, amountRoundingStrategy)
    private val productRepository = InMemoryProductRepository()
    private val productInBasketRepository = InMemoryProductInBasketRepository()

    private lateinit var addToBasketUseCase: UseCaseInput<AddToBasketRequest>
    private lateinit var purchaseUseCase: UseCaseInput<PurchaseRequest>

    fun configureComponents(presenterOutput: PresenterOutput) {
        val basketPresenter = BasketPresenter(presenterOutput)
        val receiptPresenter = ReceiptPresenter(presenterOutput)
        addToBasketUseCase = AddToBasketUseCase(
            taxCalculator,
            productRepository,
            productInBasketRepository,
            basketPresenter
        )
        purchaseUseCase = PurchaseUseCase(
            productRepository,
            productInBasketRepository,
            receiptPresenter
        )
    }

    fun retrieveAddToBasketUseCase(): UseCaseInput<AddToBasketRequest> {
        return addToBasketUseCase
    }

    fun retrievePurchaseUseCase(): UseCaseInput<PurchaseRequest> {
        return purchaseUseCase
    }

    fun feedInitialData() {
        productRepository.add(MockedData.FirstInput.BOOK)
        productRepository.add(MockedData.FirstInput.MUSIC_CD)
        productRepository.add(MockedData.FirstInput.CHOC_BAR)
        productRepository.add(MockedData.SecondInput.BOX_OF_CHOCOLATES)
        productRepository.add(MockedData.SecondInput.BOTTLE_OF_PERFUME)
        productRepository.add(MockedData.ThirdInput.IMPORTED_BOTTLE_OF_PERFUME)
        productRepository.add(MockedData.ThirdInput.BOTTLE_OF_PERFUME)
        productRepository.add(MockedData.ThirdInput.HEADACHE_PILLS)
        productRepository.add(MockedData.ThirdInput.BOX_OF_CHOCOLATES)
    }
}
