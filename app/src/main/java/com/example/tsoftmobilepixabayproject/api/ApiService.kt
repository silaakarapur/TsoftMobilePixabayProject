package com.example.tsoftmobilepixabayproject.api

import com.example.tsoftmobilepixabayproject.data.Hit
import com.example.tsoftmobilepixabayproject.data.PixabayApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/api/")
    suspend fun getImageList(
        @Query("key") apiKey : String
    ) : Response<PixabayApi>


    @GET("details")
    suspend fun getImageDetails() : Response<Hit>
}