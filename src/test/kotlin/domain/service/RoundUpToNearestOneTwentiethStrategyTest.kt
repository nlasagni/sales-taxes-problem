package domain.service

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import java.math.BigDecimal

/**
 * @author Nicola Lasagni on 11/08/2021.
 */
class RoundUpToNearestOneTwentiethStrategyTest : FreeSpec({

    val roundUpStrategy = RoundUpToNearestOneTwentiethStrategy()

    "A RoundUpToNearestOneTwentiethStrategy should round up to the nearest 0.05" - {
        roundUpStrategy.round(BigDecimal(-1.24)).shouldBe(BigDecimal(-1.24))
        roundUpStrategy.round(BigDecimal(0)).shouldBe(BigDecimal(0))
        roundUpStrategy.round(BigDecimal(0.15)).shouldBe(BigDecimal(0.15))
        roundUpStrategy.round(BigDecimal(0.5625)).shouldBe(BigDecimal(0.5625))
        roundUpStrategy.round(BigDecimal(1)).shouldBe(BigDecimal(1))
        roundUpStrategy.round(BigDecimal(22.365)).shouldBe(BigDecimal(22.365))
    }
})
