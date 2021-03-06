package pl.gdgwroclaw.workshop.save.model

import androidx.room.*

@Entity(tableName = "item")
@TypeConverters(Converters::class)
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    @Embedded
    val quantity: Quantity,
    val shopId: Int
)

data class Quantity(
    val amount: Float,
    @ColumnInfo(name = "unit_of_measurement")
    val unitOfMeasurement: UnitOfMeasurement
)

enum class UnitOfMeasurement {
    Piece, Kilogram, Litre
}

@Entity
data class Shop(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val address: String
)

data class ItemWithShop(
    @Embedded
    val item: Item,
    @Relation(parentColumn = "shopId", entityColumn = "id")
    val shop: Shop
)

class Converters {
    @TypeConverter
    fun toUnitOfMeasurement(value: String) = enumValueOf<UnitOfMeasurement>(value)

    @TypeConverter
    fun fromUnitOfMeasurement(value: UnitOfMeasurement) = value.name
}