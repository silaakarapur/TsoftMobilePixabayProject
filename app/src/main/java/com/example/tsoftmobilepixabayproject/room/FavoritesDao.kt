package com.example.tsoftmobilepixabayproject.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FavoritesDao {

    @Query("Select*From Favorite")
    fun getFavorites(): LiveData<List<Favorite>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavorites(favorite: Favorite)


}