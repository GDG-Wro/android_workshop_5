package pl.gdgwroclaw.workshop.save.model

data class Item(
    val name: String,
    val quantity: Quantity
)

data class Quantity(
    val amount: Float,
    val unitOfMeasurement: UnitOfMeasurement
)

enum class UnitOfMeasurement {
    Piece, Kilogram, Litre
}
