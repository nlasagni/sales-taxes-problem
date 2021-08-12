package adapter.presenter

/**
 * The output port of a presenter component.
 *
 * @author Nicola Lasagni on 12/08/2021.
 */
interface PresenterOutput {

    /**
     * Renders of the [viewModel] specified.
     */
    fun renderViewModel(viewModel: StringViewModel)
}
