import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

/**
 * @author Nicola Lasagni on 05/08/2021.
 */
class HelloWorldTest : FreeSpec({

    "Hello World should print proper message" - {
        HelloWorld().sayHello("Michael").shouldBe("Hello Michael, let's explore the World!")
    }
})
