package usecase.addtobasket

import domain.model.Amount
import domain.model.ProductInBasket
import domain.service.TaxAmountCalculator
import usecase.shared.ProductInBasketRepository
import usecase.shared.ProductRepository
import usecase.shared.UseCaseInput
import usecase.shared.UseCaseOutput

/**
 * @author Nicola Lasagni on 11/08/2021.
 */
class AddToBasketUseCase(
    private val taxCalculator: TaxAmountCalculator,
    private val productRepository: ProductRepository,
    private val productInBasketRepository: ProductInBasketRepository,
    private val output: UseCaseOutput<AddToBasketResponse>
) : UseCaseInput<AddToBasketRequest> {

    override fun execute(request: AddToBasketRequest) {
        val (productId, quantity) = request
        val product = productRepository.findById(productId) ?: throw ProductNotFound()
        var taxesAmount = Amount(0.0)
        var priceIncludingTaxes = Amount(0.0)
        for (i in 1..quantity) {
            val taxAmount = taxCalculator.calculateTaxAmount(product)
            taxesAmount += taxAmount
            val priceWithTaxes = product.shelfPrice + taxAmount
            priceIncludingTaxes += priceWithTaxes
        }
        val productInBasket = productInBasketRepository.add(
            ProductInBasket(productId, quantity, taxesAmount, priceIncludingTaxes)
        )
        output.handleResponse(AddToBasketResponse(productInBasket))
    }
}
