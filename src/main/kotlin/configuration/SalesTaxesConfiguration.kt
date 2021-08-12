package configuration

import adapter.presenter.BasketPresenter
import adapter.presenter.PresenterOutput
import adapter.presenter.ReceiptPresenter
import adapter.repository.InMemoryProductInBasketRepository
import adapter.repository.InMemoryProductRepository
import domain.service.TaxAmountCalculatorImpl
import domain.service.TaxRateProviderImpl
import usecase.addtobasket.AddToBasketRequest
import usecase.addtobasket.AddToBasketUseCase
import usecase.purchase.PurchaseRequest
import usecase.purchase.PurchaseUseCase
import usecase.shared.UseCaseInput

/**
 * @author Nicola Lasagni on 12/08/2021.
 */
class SalesTaxesConfiguration {

    private val taxProvider = TaxRateProviderImpl()
    private val taxCalculator = TaxAmountCalculatorImpl(taxProvider)
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
        productRepository.add(MockedData.ThirtInput.IMPORTED_BOTTLE_OF_PERFUME)
        productRepository.add(MockedData.ThirtInput.BOTTLE_OF_PERFUME)
        productRepository.add(MockedData.ThirtInput.HEADACHE_PILLS)
        productRepository.add(MockedData.ThirtInput.BOX_OF_CHOCOLATES)
    }
}
