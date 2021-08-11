package domain.model

import domain.model.exception.AmountMustBeNonNegative
import java.math.BigDecimal
import java.math.RoundingMode

/**
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

    fun ceil(scale: Int): Amount {
        return Amount(bigDecimalValue.setScale(scale, RoundingMode.CEILING).toDouble())
    }

    fun floor(scale: Int): Amount {
        return Amount(bigDecimalValue.setScale(scale, RoundingMode.FLOOR).toDouble())
    }

    operator fun plus(other: Amount): Amount {
        return Amount(value + other.value)
    }

    operator fun times(other: Amount): Amount {
        return Amount(value * other.value)
    }

    operator fun times(other: Int): Amount {
        return Amount(value * other)
    }

    operator fun div(other: Amount): Amount {
        return Amount(value / other.value)
    }

    operator fun div(other: Int): Amount {
        return Amount(value / other)
    }
}
