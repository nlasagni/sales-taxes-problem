package domain.model.exception

import domain.shared.DomainException

/**
 * Thrown to indicate that the provided tax rate is lower than or equal to zero.
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
class TaxRateMustBeGreaterThanZero : DomainException("The tax rate must be greater than zero.")
