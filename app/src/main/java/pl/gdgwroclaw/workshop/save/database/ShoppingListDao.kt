package pl.gdgwroclaw.workshop.save.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import pl.gdgwroclaw.workshop.save.model.Item
import pl.gdgwroclaw.workshop.save.model.ItemWithShop
import pl.gdgwroclaw.workshop.save.model.Shop

@Dao
interface ShoppingListDao {

    @Query("SELECT * from item ORDER BY name ASC")
    fun getItems(): Flow<List<Item>>

    @Query("SELECT * from item")
    fun getItemsWithShops(): Flow<List<ItemWithShop>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: Item)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShop(shop: Shop)

    @Query("DELETE FROM item WHERE id = :id")
    suspend fun delete(id: Int)
}
