package domain.model.exception

import domain.shared.DomainException

/**
 * Thrown to indicate that the provided quantity is lower than or equal to zero.
 *
 * @author Nicola Lasagni on 12/08/2021.
 */
class QuantityMustBeGreaterThanZero :
    DomainException("The quantity of products in the basket must be greater than zero.")
