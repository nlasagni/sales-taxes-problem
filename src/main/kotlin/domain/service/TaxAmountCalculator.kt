package domain.service

import domain.model.Amount
import domain.model.Product

/**
 * Calculates tax amount and taxed prices of [Product]s.
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
interface TaxAmountCalculator {

    /**
     * Calculates the amount of taxes for the given [product].
     * @return The taxes amount.
     */
    fun calculateTaxAmount(product: Product): Amount
}
