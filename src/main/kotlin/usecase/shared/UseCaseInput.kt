package usecase.shared

/**
 * The input port of the Use Case layer.
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
interface UseCaseInput<T> {

    /**
     * Executes the task related to the [request] specified.
     */
    fun execute(request: T)

}