package usecase.purchase

import domain.model.Amount
import domain.model.ProductInBasket
import domain.model.Receipt
import domain.service.TaxAmountCalculatorImpl
import usecase.shared.UseCaseInput
import usecase.shared.UseCaseOutput

/**
 * Makes a purchase of items specified by the [PurchaseRequest].
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
class PurchaseUseCase(
    private val taxCalculator: TaxAmountCalculatorImpl,
    private val output: UseCaseOutput<PurchaseResponse>
) : UseCaseInput<PurchaseRequest> {

    override fun execute(request: PurchaseRequest) {
        val products = request.products
        var totalSalesTaxes = Amount(0.0)
        var totalPrice = Amount(0.0)
        val purchasedProducts = mutableListOf<ProductInBasket>()
        for (product in products) {
            val taxAmount = taxCalculator.calculateTaxAmount(product)
            totalSalesTaxes += taxAmount
            val priceWithTaxes = product.shelfPrice + taxAmount
            totalPrice += priceWithTaxes
            purchasedProducts.add(ProductInBasket(product.id, 1, priceWithTaxes, Amount(0.0)))
        }
        val receipt = Receipt(purchasedProducts, totalSalesTaxes, totalPrice)
        val response = PurchaseResponse(receipt)
        output.handleResponse(response)
    }
}
