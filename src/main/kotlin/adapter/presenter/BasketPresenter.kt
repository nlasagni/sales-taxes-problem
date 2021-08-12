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
        val product = response.productInBasket
        val stringBuilder = StringBuilder()
        stringBuilder.appendLine("Product added to basket:")
        stringBuilder.appendLine("Id: ${product.productId}")
        stringBuilder.appendLine("Quantity: ${product.quantity}")
        stringBuilder.appendLine(
            "Taxes Amount: ${product.productId}, Id: ${product.taxesAmount.formatToTwoDecimals()}"
        )
        output.renderViewModel(StringViewModel(stringBuilder.toString()))
    }
}
