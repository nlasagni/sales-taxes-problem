package usecase.shared

/**
 * Class that represents the error generated from the
 * processing of a use case input request.
 *
 * @property error The error message.
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
data class UseCaseError(val error: String)
