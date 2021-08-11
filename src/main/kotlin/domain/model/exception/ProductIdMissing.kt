package domain.model.exception

import domain.shared.DomainException

/**
 * Thrown to indicate that an id is missing for a Product.
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
class ProductIdMissing : DomainException("Product unique id missing.")