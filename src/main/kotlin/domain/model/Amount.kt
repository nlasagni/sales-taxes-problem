package domain.model

import domain.model.exception.AmountMustBeNonNegative
import java.math.BigDecimal
import java.math.RoundingMode

/**
 * The amount of a price or a tax.
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
data class Amount(private val value: Double) {

    private var bigDecimalValue = BigDecimal.ZERO

    companion object {
        fun of(value: Int): Amount {
            return Amount(value.toDouble())
        }
    }

    init {
        if (value < 0) {
            throw AmountMustBeNonNegative()
        }
        bigDecimalValue = BigDecimal(value)
    }

    /**
     * Rounds up to the next decimal or integer, depending on the [scale] specified.
     * @return The rounded-up Amount.
     */
    fun ceil(scale: Int): Amount {
        return Amount(bigDecimalValue.setScale(scale, RoundingMode.CEILING).toDouble())
    }

    /**
     * Rounds down towards zero.
     * @return The new floored Amount.
     */
    fun roundDown(scale: Int): Amount {
        return Amount(bigDecimalValue.setScale(scale, RoundingMode.DOWN).toDouble())
    }

    /**
     * Formats the amount by including only two decimals.
     */
    fun formatToTwoDecimals(): String {
        return String.format("%.2f", value)
    }

    /**
     * Sum [other] amount to this amount.
     *
     */
    operator fun plus(other: Amount): Amount {
        return Amount(value + other.value)
    }

    /**
     * Multiplies this amount by [other] amount.
     */
    operator fun times(other: Amount): Amount {
        return Amount(value * other.value)
    }

    /**
     * Multiplies this amount by [other] amount.
     */
    operator fun times(other: Int): Amount {
        return Amount(value * other)
    }

    /**
     * Divides this amount by [other].
     */
    operator fun div(other: Amount): Amount {
        return Amount(value / other.value)
    }

    /**
     * Divides this amount by [other].
     */
    operator fun div(other: Int): Amount {
        return Amount(value / other)
    }
}
