package usecase.purchase

import domain.model.Amount
import domain.model.ProductInReceipt
import domain.model.Receipt
import usecase.shared.ProductInBasketRepository
import usecase.shared.ProductNotFound
import usecase.shared.ProductRepository
import usecase.shared.UseCaseInput
import usecase.shared.UseCaseOutput

/**
 * Makes a purchase of the products previously added to the basket.
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
class PurchaseUseCase(
    private val productRepository: ProductRepository,
    private val productInBasketRepository: ProductInBasketRepository,
    private val output: UseCaseOutput<PurchaseResponse>
) : UseCaseInput<PurchaseRequest> {

    override fun execute(request: PurchaseRequest) {
        val productsInBasket = productInBasketRepository.findAll()
        if (productsInBasket.isEmpty()) {
            throw BasketIsEmpty()
        }
        var totalSalesTaxes = Amount(0.0)
        var totalPrice = Amount(0.0)
        val productsInReceipt = mutableListOf<ProductInReceipt>()
        for (productInBasket in productsInBasket) {
            val product = productRepository.findById(productInBasket.productId) ?: throw ProductNotFound()
            val taxesAmount = productInBasket.taxesAmount
            val totalShelfPrice = product.shelfPrice * productInBasket.quantity
            val totalShelfPriceIncludingTaxes = totalShelfPrice + productInBasket.taxesAmount
            totalSalesTaxes += taxesAmount
            totalPrice += totalShelfPriceIncludingTaxes
            productsInReceipt.add(
                ProductInReceipt(
                    product.name,
                    productInBasket.quantity,
                    taxesAmount,
                    totalShelfPriceIncludingTaxes,
                    product.imported
                )
            )
        }
        productInBasketRepository.deleteAll()
        val receipt = Receipt(productsInReceipt, totalSalesTaxes, totalPrice)
        val response = PurchaseResponse(receipt)
        output.handleResponse(response)
    }
}
