package domain.service

import domain.model.Product
import domain.model.TaxRate

/**
 * Provides tax rate based on [Product].
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
interface TaxRateProvider {

    /**
     * Provides the [TaxRate] for the given [product].
     * @return The product-related tax rate.
     */
    fun provideTaxRate(product: Product): TaxRate
}
