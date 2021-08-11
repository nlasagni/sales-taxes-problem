package usecase.purchase

import domain.model.Item
import domain.service.TaxCalculator
import usecase.shared.UseCaseInput
import usecase.shared.UseCaseOutput
import usecase.shared.model.UseCaseResponse

/**
 * Makes a purchase of items specified by the [PurchaseRequest].
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
class PurchaseUseCase(
    private val taxCalculator: TaxCalculator,
    private val output: UseCaseOutput<PurchaseResponse>
) : UseCaseInput<PurchaseRequest> {

    override fun execute(request: PurchaseRequest) {
        val items = request.items
        var totalSalesTaxes = 0f
        var totalPrice = 0f
        val itemsWithTaxes = mutableListOf<Item>()
        for (item in items) {
            totalSalesTaxes += taxCalculator.calculateTaxAmount(item)
            val priceWithTaxes = taxCalculator.calculateTaxedPrice(item)
            totalPrice += priceWithTaxes
            itemsWithTaxes.add(Item(item.name, item.category, item.quantity, priceWithTaxes, item.imported))
        }
        val response = PurchaseResponse(itemsWithTaxes, totalSalesTaxes, totalPrice)
        output.handleResponse(UseCaseResponse(response))
    }
}
