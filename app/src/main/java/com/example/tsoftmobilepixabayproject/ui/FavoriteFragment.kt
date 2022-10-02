package com.example.tsoftmobilepixabayproject.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tsoftmobilepixabayproject.adapter.FavoritesPhotoAdapter
import com.example.tsoftmobilepixabayproject.databinding.FragmentFavoriteBinding
import com.example.tsoftmobilepixabayproject.room.Favorite
import com.example.tsoftmobilepixabayproject.viewmodel.FavoritesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment() {
    lateinit var binding: FragmentFavoriteBinding
    var oldMyNotes = arrayListOf<Favorite>()
    lateinit var adapter: FavoritesPhotoAdapter
    val viewModel: FavoritesViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)

        viewModel.getFavorites().observe(viewLifecycleOwner) { favoritesList ->

            for (i in favoritesList) {
                println("favori başarılı")
                oldMyNotes = favoritesList as ArrayList<Favorite>
                adapter = FavoritesPhotoAdapter(requireContext(), favoritesList)
                binding.favoritesPhotoList.layoutManager = GridLayoutManager(requireContext(), 2)
                binding.favoritesPhotoList.adapter = adapter

            }

        }


        return binding.root
    }

 
}

