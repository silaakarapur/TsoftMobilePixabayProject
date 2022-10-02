package com.example.tsoftmobilepixabayproject.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.tsoftmobilepixabayproject.room.Favorite
import com.example.tsoftmobilepixabayproject.room.FavoritesDatabase
import com.example.tsoftmobilepixabayproject.room.FavoritesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor (application: Application) : AndroidViewModel(application) {

    var repository: FavoritesRepository


    init {
        val dao = FavoritesDatabase.getDatabaseInstance(application).myFavoritesDao()
        repository = FavoritesRepository(dao)

    }

    fun addNotes(favorite: Favorite) {
        repository.insertFavorites(favorite)
    }

    fun getFavorites(): LiveData<List<Favorite>> = repository.getAllData()





}