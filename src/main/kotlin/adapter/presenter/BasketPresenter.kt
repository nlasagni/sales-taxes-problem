package adapter.presenter

import usecase.addtobasket.AddToBasketResponse
import usecase.shared.UseCaseOutput

/**
 * A presenter which processes output data coming from add-to-basket-related use cases.
 *
 * @author Nicola Lasagni on 12/08/2021.
 */
class BasketPresenter(private val output: PresenterOutput) : UseCaseOutput<AddToBasketResponse> {

    override fun handleResponse(response: AddToBasketResponse) {
        val stringBuilder = StringBuilder()
        stringBuilder.appendLine("Product added to basket:")
        stringBuilder.appendLine(response.productInBasket.toString())
        output.renderViewModel(StringViewModel(stringBuilder.toString()))
    }
}
