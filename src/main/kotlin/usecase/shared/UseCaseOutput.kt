package usecase.shared

/**
 * The output port of the Use Case layer.
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
interface UseCaseOutput<T> {

    /**
     * Handles the [response] generated from the processing of the input port request.
     */
    fun handleResponse(response: T)
}
