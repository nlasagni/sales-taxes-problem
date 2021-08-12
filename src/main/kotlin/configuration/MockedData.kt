package configuration

import domain.model.Amount
import domain.model.Product
import domain.model.ProductCategory
import domain.model.ProductId

/**
 * Object that contains the data coming from the example inputs.
 *
 * @author Nicola Lasagni on 12/08/2021.
 */
object MockedData {

    object FirstInput {
        val BOOK_ID = ProductId("1")
        val MUSIC_CD_ID = ProductId("2")
        val CHOCOLATE_BAR_ID = ProductId("3")

        private const val BOOK_PRICE = 12.49
        private const val MUSIC_CD_PRICE = 14.99
        private const val CHOCOLATE_BAR_PRICE = 0.85

        val BOOK = Product(
            id = BOOK_ID,
            name = "book",
            category = ProductCategory.BOOK,
            shelfPrice = Amount(BOOK_PRICE),
            imported = false
        )
        val MUSIC_CD = Product(
            id = MUSIC_CD_ID,
            name = "music CD",
            category = ProductCategory.MISCELLANEOUS,
            shelfPrice = Amount(MUSIC_CD_PRICE),
            imported = false
        )
        val CHOC_BAR = Product(
            id = CHOCOLATE_BAR_ID,
            name = "chocolate bar",
            category = ProductCategory.FOOD,
            shelfPrice = Amount(CHOCOLATE_BAR_PRICE),
            imported = false
        )
    }

    object SecondInput {
        val BOX_OF_CHOCOLATES_ID = ProductId("4")
        val BOTTLE_OF_PERFUME_ID = ProductId("5")

        private const val BOX_OF_CHOCOLATES_PRICE = 10.0
        private const val BOTTLE_OF_PERFUME_PRICE = 47.50

        val BOX_OF_CHOCOLATES = Product(
            id = BOX_OF_CHOCOLATES_ID,
            name = "box of chocolates",
            category = ProductCategory.FOOD,
            shelfPrice = Amount(BOX_OF_CHOCOLATES_PRICE),
            imported = true
        )
        val BOTTLE_OF_PERFUME = Product(
            id = BOTTLE_OF_PERFUME_ID,
            name = "bottle of perfume",
            category = ProductCategory.MISCELLANEOUS,
            shelfPrice = Amount(BOTTLE_OF_PERFUME_PRICE),
            imported = true
        )
    }

    object ThirdInput {
        val IMPORTED_BOTTLE_OF_PERFUME_ID = ProductId("6")
        val BOTTLE_OF_PERFUME_ID = ProductId("7")
        val HEADACHE_PILLS_ID = ProductId("8")
        val BOX_OF_CHOCOLATES_ID = ProductId("9")

        const val BOX_OF_CHOCOLATES_QUANTITY = 3

        private const val IMPORTED_BOTTLE_OF_PERFUME_PRICE = 27.99
        private const val BOTTLE_OF_PERFUME_PRICE = 18.99
        private const val HEADACHE_PILLS_PRICE = 9.75
        private const val BOX_OF_CHOCOLATES_PRICE = 11.25

        val IMPORTED_BOTTLE_OF_PERFUME = Product(
            id = IMPORTED_BOTTLE_OF_PERFUME_ID,
            name = "bottle of perfume",
            category = ProductCategory.MISCELLANEOUS,
            shelfPrice = Amount(IMPORTED_BOTTLE_OF_PERFUME_PRICE),
            imported = true
        )
        val BOTTLE_OF_PERFUME = Product(
            id = BOTTLE_OF_PERFUME_ID,
            name = "bottle of perfume",
            category = ProductCategory.MISCELLANEOUS,
            shelfPrice = Amount(BOTTLE_OF_PERFUME_PRICE),
            imported = false
        )
        val HEADACHE_PILLS = Product(
            id = HEADACHE_PILLS_ID,
            name = "packet of headache pills",
            category = ProductCategory.MEDICAL,
            shelfPrice = Amount(HEADACHE_PILLS_PRICE),
            imported = false
        )
        val BOX_OF_CHOCOLATES = Product(
            id = BOX_OF_CHOCOLATES_ID,
            name = "box of chocolates",
            category = ProductCategory.FOOD,
            shelfPrice = Amount(BOX_OF_CHOCOLATES_PRICE),
            imported = true
        )
    }
}
