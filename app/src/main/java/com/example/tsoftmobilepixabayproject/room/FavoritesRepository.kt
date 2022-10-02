package com.example.tsoftmobilepixabayproject.room

import androidx.lifecycle.LiveData

class FavoritesRepository(val dao: FavoritesDao) {

    fun getAllData(): LiveData<List<Favorite>> =dao.getFavorites()

    fun insertFavorites(favorite: Favorite){
        dao.insertFavorites(favorite)
    }

}