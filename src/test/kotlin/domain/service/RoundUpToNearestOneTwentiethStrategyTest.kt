package domain.service

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

/**
 * @author Nicola Lasagni on 11/08/2021.
 */
class RoundUpToNearestOneTwentiethStrategyTest : FreeSpec({

    val roundUpStrategy = RoundUpToNearestOneTwentiethStrategy()

    "A RoundUpToNearestOneTwentiethStrategy should round up to the nearest 0.05" - {
        roundUpStrategy.round(-1.24f).shouldBe(-1.20f)
        roundUpStrategy.round(0f).shouldBe(0f)
        roundUpStrategy.round(0.15f).shouldBe(0.15f)
        roundUpStrategy.round(0.5625f).shouldBe(0.6f)
        roundUpStrategy.round(1f).shouldBe(1f)
        roundUpStrategy.round(22.365f).shouldBe(22.40f)
    }
})
