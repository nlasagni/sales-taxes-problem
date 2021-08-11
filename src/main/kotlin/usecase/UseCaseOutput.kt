package usecase

import usecase.model.UseCaseError
import usecase.model.UseCaseResponse

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