package pl.gdgwroclaw.workshop.save.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pl.gdgwroclaw.workshop.save.model.Item
import pl.gdgwroclaw.workshop.save.model.Shop

@Database(entities = [Item::class, Shop::class], version = 1, exportSchema = false)
abstract class ShoppingListDatabase : RoomDatabase() {

    abstract fun dao(): ShoppingListDao

    companion object {
        private lateinit var applicationContext: Context

        val database by lazy {
            Room.databaseBuilder(
                applicationContext,
                ShoppingListDatabase::class.java,
                "shopping_list.db"
            ).build()
        }

        fun initialize(context: Context) {
            applicationContext = context.applicationContext
        }
    }
}