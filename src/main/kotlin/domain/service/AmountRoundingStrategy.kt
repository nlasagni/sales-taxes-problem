package domain.service

import java.math.BigDecimal

/**
 * Strategy for rounding taxes.
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
interface AmountRoundingStrategy {

    /**
     * Round the given [amount] by following the implemented strategy.
     * @return The rounded value.
     */
    fun round(amount: BigDecimal): BigDecimal
}
