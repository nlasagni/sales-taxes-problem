package domain.service

import java.math.BigDecimal
import kotlin.math.ceil

/**
 * Rounds a value up to the nearest 0.05.
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
class RoundUpToNearestOneTwentiethStrategy : AmountRoundingStrategy {

    companion object {
        private const val ROUND_UNIT = 0.05
    }

    override fun round(amount: BigDecimal): BigDecimal {
        val amountDouble = amount.toDouble()
        return BigDecimal.valueOf(ceil(amountDouble / ROUND_UNIT) * ROUND_UNIT)
    }
}
