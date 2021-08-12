import adapter.presenter.PresenterOutput
import adapter.presenter.StringViewModel
import configuration.MockedData
import configuration.SalesTaxesConfiguration
import usecase.addtobasket.AddToBasketRequest
import usecase.purchase.PurchaseRequest
import usecase.shared.UseCaseInput

/**
 * The application starting class, responsible of executing the use cases in order to simulate the input
 * provided by the problem examples.
 *
 * @author Nicola Lasagni on 12/08/2021.
 */
class SalesTaxesApplication : PresenterOutput {

    private val configuration = SalesTaxesConfiguration()
    private val addToBasketUseCase: UseCaseInput<AddToBasketRequest> by lazy {
        configuration.retrieveAddToBasketUseCase()
    }
    private val purchaseUseCase: UseCaseInput<PurchaseRequest> by lazy {
        configuration.retrievePurchaseUseCase()
    }

    fun start() {
        configuration.configureComponents(this)
        configuration.feedInitialData()
        processFirstInput()
        processSecondInput()
        processThirdInput()
    }

    private fun processFirstInput() {
        addToBasketUseCase.execute(AddToBasketRequest(MockedData.FirstInput.BOOK_ID, 2))
        addToBasketUseCase.execute(AddToBasketRequest(MockedData.FirstInput.MUSIC_CD_ID, 1))
        addToBasketUseCase.execute(AddToBasketRequest(MockedData.FirstInput.CHOCOLATE_BAR_ID, 1))
        purchaseUseCase.execute(PurchaseRequest())
    }

    private fun processSecondInput() {
        addToBasketUseCase.execute(AddToBasketRequest(MockedData.SecondInput.BOX_OF_CHOCOLATES_ID, 1))
        addToBasketUseCase.execute(AddToBasketRequest(MockedData.SecondInput.BOTTLE_OF_PERFUME_ID, 1))
        purchaseUseCase.execute(PurchaseRequest())
    }

    private fun processThirdInput() {
        addToBasketUseCase.execute(AddToBasketRequest(MockedData.ThirdInput.IMPORTED_BOTTLE_OF_PERFUME_ID, 1))
        addToBasketUseCase.execute(AddToBasketRequest(MockedData.ThirdInput.BOTTLE_OF_PERFUME_ID, 1))
        addToBasketUseCase.execute(AddToBasketRequest(MockedData.ThirdInput.HEADACHE_PILLS_ID, 1))
        addToBasketUseCase.execute(
            AddToBasketRequest(
                MockedData.ThirdInput.BOX_OF_CHOCOLATES_ID,
                MockedData.ThirdInput.BOX_OF_CHOCOLATES_QUANTITY
            )
        )
        purchaseUseCase.execute(PurchaseRequest())
    }

    override fun renderViewModel(viewModel: StringViewModel) {
        println(viewModel.content)
    }
}

fun main() {
    SalesTaxesApplication().start()
}
