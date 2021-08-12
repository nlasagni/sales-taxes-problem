package usecase.purchase

/**
 * Thrown to indicate that the desired basket is empty.
 *
 * @author Nicola Lasagni on 12/08/2021.
 */
class BasketIsEmpty : Exception("The basket is empty, so no product can be purchased.")
