package domain.model.exception

import domain.shared.DomainException

/**
 * Thrown to indicate that the provided amount is lower than zero.
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
class AmountMustBeNonNegative : DomainException("The amount must be non-negative.")
