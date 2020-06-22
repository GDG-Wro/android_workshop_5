package pl.gdgwroclaw.workshop.save.ui

import pl.gdgwroclaw.workshop.save.model.Item
import pl.gdgwroclaw.workshop.save.model.Quantity
import pl.gdgwroclaw.workshop.save.model.UnitOfMeasurement

object ItemLibrary {
    val items = arrayOf(
        Item(
            name = "milk",
            quantity = Quantity(
                amount = 1f,
                unitOfMeasurement = UnitOfMeasurement.Litre
            ),
            shopId = 1
        ),
        Item(
            name = "bread",
            quantity = Quantity(
                amount = 1f,
                unitOfMeasurement = UnitOfMeasurement.Piece
            ), shopId = 1

        ),
        Item(
            name = "potatoes",
            quantity = Quantity(
                amount = 2.5f,
                unitOfMeasurement = UnitOfMeasurement.Kilogram
            ), shopId = 2
        ),
        Item(
            name = "orange juice",
            quantity = Quantity(
                amount = 1f,
                unitOfMeasurement = UnitOfMeasurement.Litre
            ), shopId = 2
        )
    )
}