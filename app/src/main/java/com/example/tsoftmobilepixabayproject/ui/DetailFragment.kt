package com.example.tsoftmobilepixabayproject.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.tsoftmobilepixabayproject.databinding.FragmentDetailBinding
import com.example.tsoftmobilepixabayproject.loadImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private var binding:FragmentDetailBinding?=null
    val detail by navArgs<com.example.tsoftmobilepixabayproject.ui.DetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDetailBinding.inflate(inflater, container, false)
        binding?.imageView?.loadImage(detail.data.webformatURL)
        binding?.like?.text = detail.data.likes.toString()+" ("+detail.data.comments.toString()+" Yorum)"
        binding?.user?.text=detail.data.user
        binding?.userimage?.loadImage(detail.data.userImageURL)
        return binding?.root
    }


}