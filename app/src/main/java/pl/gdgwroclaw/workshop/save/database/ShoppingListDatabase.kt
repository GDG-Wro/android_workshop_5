package pl.gdgwroclaw.workshop.save.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pl.gdgwroclaw.workshop.save.model.Item

@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class ShoppingListDatabase : RoomDatabase() {

    abstract fun dao(): ShoppingListDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time. 
        @Volatile
        private var INSTANCE: ShoppingListDatabase? = null

        fun getDatabase(context: Context): ShoppingListDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ShoppingListDatabase::class.java,
                    "shopping_list"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}