package usecase.shared

/**
 * Thrown to indicate that the desired product is not present.
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
class ProductNotFound : Exception("Product with provided identifier not found.")
