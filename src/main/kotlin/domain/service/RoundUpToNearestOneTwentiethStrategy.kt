package domain.service

import kotlin.math.ceil

/**
 * Rounds a value to the nearest 0.05.
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
class RoundUpToNearestOneTwentiethStrategy : TaxRoundingStrategy {

    companion object {
        private const val ROUND_UNIT = 0.05f
    }

    override fun round(value: Float): Float {
        return ceil(value / ROUND_UNIT) * ROUND_UNIT
    }
}
