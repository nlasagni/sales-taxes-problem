package domain.service

/**
 * Strategy for rounding taxes.
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
interface TaxRoundingStrategy {

    /**
     * Round the given [value] by following the implemented strategy.
     * @return The rounded value.
     */
    fun round(value: Float): Float
}
