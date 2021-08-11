package domain.model.exception

import domain.shared.DomainException

/**
 * Thrown to indicate that the provided name is empty.
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
class NameMustNotBeEmpty : DomainException("Name must not be empty.")
