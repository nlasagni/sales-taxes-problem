package usecase.addtobasket

import usecase.shared.UseCaseOutput

/**
 * @author Nicola Lasagni on 11/08/2021.
 */
class MockedUseCaseOutput : UseCaseOutput<AddToBasketResponse> {
    override fun handleResponse(response: AddToBasketResponse) {
        // Empty method, created only for test purposes
    }
}
