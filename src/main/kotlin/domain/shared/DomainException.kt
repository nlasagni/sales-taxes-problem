package domain.shared

/**
 * Class that represents possible exceptions thrown by the Domain layer.
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
open class DomainException(message: String) : Exception(message)