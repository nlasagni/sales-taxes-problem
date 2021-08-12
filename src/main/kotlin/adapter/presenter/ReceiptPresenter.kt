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
        stringBuilder.appendLine("Purchase Receipt")
        for (product in receipt.productInBaskets) {
            val productName = if (product.imported) "imported " + product.name else product.name
            stringBuilder.appendLine(
                "${product.quantity} $productName: ${product.shelfPriceIncludingTaxes.formatToTwoDecimals()}"
            )
        }
        stringBuilder.appendLine("Sales Taxes: ${receipt.totalSalesTaxes.formatToTwoDecimals()}")
        stringBuilder.appendLine("Total: ${receipt.totalPrice.formatToTwoDecimals()}")
        output.renderViewModel(StringViewModel(stringBuilder.toString()))
    }
}
