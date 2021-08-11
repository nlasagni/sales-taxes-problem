package domain.service

/**
 * Strategy for rounding taxes.
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
interface TaxRoundingStrategy {

    fun round(value: Float): Float
}
