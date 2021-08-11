package usecase.purchase

import domain.model.Item

/**
 * Request coming from outer layer for purchasing [Item]s.
 *
 * @author Nicola Lasagni on 11/08/2021.
 */
data class PurchaseRequest(
    val items: Collection<Item>
)
