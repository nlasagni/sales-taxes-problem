package domain.service

import domain.model.Amount
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

/**
 * @author Nicola Lasagni on 11/08/2021.
 */
class RoundUpToNearestOneTwentiethStrategyTest : FreeSpec({

    val roundUpStrategy = RoundUpToNearestOneTwentiethStrategy()

    "A RoundUpToNearestOneTwentiethStrategy should round up to the nearest 0.05" - {
        roundUpStrategy.round(Amount(0.0)).shouldBe(Amount(0.0))
        roundUpStrategy.round(Amount(0.1468)).shouldBe(Amount(0.15))
        roundUpStrategy.round(Amount(0.5625)).shouldBe(Amount(0.6))
        roundUpStrategy.round(Amount(1.0)).shouldBe(Amount(1.0))
        roundUpStrategy.round(Amount(1.2177)).shouldBe(Amount(1.25))
        roundUpStrategy.round(Amount(1.34997)).shouldBe(Amount(1.35))
        roundUpStrategy.round(Amount(22.365)).shouldBe(Amount(22.4))
    }
})
