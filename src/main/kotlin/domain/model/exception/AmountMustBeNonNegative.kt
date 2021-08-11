package domain.model.exception

import domain.shared.DomainException

/**
 * Thrown to indicate that the provided price is lower than or equal to zero.
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
class PriceMustBeGreaterThanZero : DomainException("The price of an item must be greater than zero.")
