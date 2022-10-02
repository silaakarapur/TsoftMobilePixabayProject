package com.example.tsoftmobilepixabayproject.room

import android.R.string
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull


@Entity(tableName = "Favorite")
class Favorite (
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var image: String,
    var like: String ,
    var views: String,
    var comments: String?

)