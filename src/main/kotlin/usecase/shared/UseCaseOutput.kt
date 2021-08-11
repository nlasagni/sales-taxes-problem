package usecase.shared

import usecase.shared.model.UseCaseError
import usecase.shared.model.UseCaseResponse

/**
 * The output port of the Use Case layer.
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
interface UseCaseOutput<T> {

    /**
     * Handles the [response] generated from the processing of the input port request.
     */
    fun handleResponse(response: UseCaseResponse<T>)

    /**
     * Handles the [error] generated from the processing of the input port request.
     */
    fun handleError(error: UseCaseError)
}
