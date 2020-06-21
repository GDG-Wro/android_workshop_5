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
            )
        ),
        Item(
            name = "bread",
            quantity = Quantity(
                amount = 1f,
                unitOfMeasurement = UnitOfMeasurement.Piece
            )
        ),
        Item(
            name = "potatoes",
            quantity = Quantity(
                amount = 2.5f,
                unitOfMeasurement = UnitOfMeasurement.Kilogram
            )
        ),
        Item(
            name = "orange juice",
            quantity = Quantity(
                amount = 1f,
                unitOfMeasurement = UnitOfMeasurement.Litre
            )
        )
    )
}