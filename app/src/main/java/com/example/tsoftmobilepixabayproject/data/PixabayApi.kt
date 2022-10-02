package com.example.tsoftmobilepixabayproject.data

data class PixabayApi(
    val hits: List<Hit>,
    val total: Int,
    val totalHits: Int
)
