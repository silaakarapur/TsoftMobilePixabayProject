package com.example.tsoftmobilepixabayproject.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tsoftmobilepixabayproject.adapter.PhotoListAdapter
import com.example.tsoftmobilepixabayproject.data.Hit
import com.example.tsoftmobilepixabayproject.databinding.FragmentHomeBinding
import com.example.tsoftmobilepixabayproject.databinding.ListCardViewBinding
import com.example.tsoftmobilepixabayproject.loadImage
import com.example.tsoftmobilepixabayproject.viewmodel.PhotoListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var binding: FragmentHomeBinding? = null
    private var viewModel: PhotoListViewModel? = null
private var _binding:ListCardViewBinding?=null
    private var adapter: PhotoListAdapter? = null
    private var apiKey = "28047783-b1ea0198798957e25a1771204"
    private lateinit var photoList: List<Hit>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        initViewModel()
        initObserver()
        viewModel?.downloadPhotos(apiKey)


        return binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this@HomeFragment)[PhotoListViewModel::class.java]
    }

    private fun initObserver() {
        viewModel?.currentPhotoList?.observe(viewLifecycleOwner, Observer {
            initAdapter(it)
        })
    }

    private fun initAdapter(photoList: List<Hit>) {
        adapter = PhotoListAdapter(photoList, object : PhotoListAdapter.ItemClickListener {
            override fun onClick(data: Hit) {

            }
        })
        binding?.photolist?.adapter = adapter
        binding?.photolist?.layoutManager = GridLayoutManager(requireContext(), 2)


    }




}