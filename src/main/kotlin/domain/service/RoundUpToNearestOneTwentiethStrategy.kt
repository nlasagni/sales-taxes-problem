package domain.service

import domain.model.Amount

/**
 * Rounds a value up to the nearest 0.05.
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
class RoundUpToNearestOneTwentiethStrategy : AmountRoundingStrategy {

    companion object {
        private val ROUND_UNIT = Amount(0.05)
        private const val ROUND_SCALE_TO_INT = 0
        private const val ROUND_SCALE_TWO_DECIMALS = 2
    }

    override fun round(amount: Amount): Amount {
        return ((amount / ROUND_UNIT).ceil(ROUND_SCALE_TO_INT) * ROUND_UNIT).roundDown(ROUND_SCALE_TWO_DECIMALS)
    }
}
