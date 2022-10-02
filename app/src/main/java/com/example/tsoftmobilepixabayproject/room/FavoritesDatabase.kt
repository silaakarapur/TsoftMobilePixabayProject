package com.example.tsoftmobilepixabayproject.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Favorite::class], version = 1, exportSchema = false)
abstract class FavoritesDatabase :RoomDatabase(){
 abstract fun myFavoritesDao():FavoritesDao

    companion object {
        @Volatile
        var Instance: FavoritesDatabase? = null

        fun getDatabaseInstance(context: Context): FavoritesDatabase {
            val tempInstance = Instance
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val roomDatabaseInstance =
                    Room.databaseBuilder(context, FavoritesDatabase::class.java, "Favorite").allowMainThreadQueries().build()
                Instance = roomDatabaseInstance
                return roomDatabaseInstance
            }
        }
    }
}