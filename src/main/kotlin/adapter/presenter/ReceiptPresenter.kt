package adapter.presenter

import usecase.purchase.PurchaseResponse
import usecase.shared.UseCaseOutput

/**
 * A presenter which processes output data coming from purchase-related use cases.
 *
 * @author Nicola Lasagni on 12/08/2021.
 */
class ReceiptPresenter(private val output: PresenterOutput) : UseCaseOutput<PurchaseResponse> {

    override fun handleResponse(response: PurchaseResponse) {
        val receipt = response.receipt
        val stringBuilder = StringBuilder()
        stringBuilder.appendLine("Receipt")
        for (product in receipt.productInBaskets) {
            stringBuilder.appendLine("${product.quantity} ${product.name}: ${product.shelfPriceIncludingTaxes}")
        }
        stringBuilder.appendLine("Sales Taxes: ${receipt.totalSalesTaxes}")
        stringBuilder.appendLine("Total: ${receipt.totalPrice}")
        output.renderViewModel(StringViewModel(stringBuilder.toString()))
    }
}
