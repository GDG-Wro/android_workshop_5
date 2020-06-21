package pl.gdgwroclaw.workshop.save.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import pl.gdgwroclaw.workshop.save.model.Item

@Dao
interface ShoppingListDao {

    @Query("SELECT * from item ORDER BY name ASC")
    fun getItems(): Flow<List<Item>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)

    @Query("DELETE FROM item WHERE id = :id")
    suspend fun delete(id: Long)
}
