package com.example.tsoftmobilepixabayproject.viewmodel

import androidx.appcompat.widget.SearchView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tsoftmobilepixabayproject.adapter.PhotoListAdapter
import com.example.tsoftmobilepixabayproject.api.ApiClient
import com.example.tsoftmobilepixabayproject.api.ApiService
import com.example.tsoftmobilepixabayproject.data.Hit
import com.example.tsoftmobilepixabayproject.databinding.FragmentHomeBinding
import com.example.tsoftmobilepixabayproject.databinding.FragmentSearchBinding
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PhotoListViewModel @Inject constructor() : ViewModel(){
    val currentPhotoList = MutableLiveData<List<Hit>>()
    var job : Job? = null

    val apiClient = ApiClient.getClient().create(ApiService::class.java)
    fun downloadPhotos(apiKey : String){
        job = viewModelScope.launch(Dispatchers.IO){
            var response = apiClient.getImageList(apiKey)

            withContext(Dispatchers.Main){
                if (response.isSuccessful){
                    response.body()?.let {
                        currentPhotoList.value = it.hits
                    }
                }
            }
        }
    }





}