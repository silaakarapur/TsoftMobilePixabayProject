package com.example.tsoftmobilepixabayproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Database
import com.example.tsoftmobilepixabayproject.data.Hit
import com.example.tsoftmobilepixabayproject.databinding.ListCardViewBinding
import com.example.tsoftmobilepixabayproject.loadImage
import com.example.tsoftmobilepixabayproject.room.Favorite
import com.example.tsoftmobilepixabayproject.ui.HomeFragmentDirections
import com.example.tsoftmobilepixabayproject.viewmodel.FavoritesViewModel

class FavoritesPhotoAdapter (val requireContext: Context, var favoritesList: List<Favorite>
) : RecyclerView.Adapter<FavoritesPhotoAdapter.FavoritesListVH>() {

    class FavoritesListVH(val binding: ListCardViewBinding) : RecyclerView.ViewHolder(binding.root){}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesListVH {
        val view = ListCardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoritesListVH(view)
    }



    // gelen görüntüleri recyclerview ile liste oluşturulduğundan imageview'a ve textView'e Gönderiyoruz
    override fun onBindViewHolder(holder: FavoritesListVH, position: Int) {
        val data = favoritesList[position]
        holder.binding.views.text=data.views

    }

    override fun getItemCount(): Int {
        return favoritesList.size
    }

}