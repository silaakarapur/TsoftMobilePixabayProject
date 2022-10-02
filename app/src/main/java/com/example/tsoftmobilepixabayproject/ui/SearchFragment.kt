package com.example.tsoftmobilepixabayproject.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tsoftmobilepixabayproject.adapter.PhotoListAdapter
import com.example.tsoftmobilepixabayproject.data.Hit
import com.example.tsoftmobilepixabayproject.databinding.FragmentHomeBinding

import com.example.tsoftmobilepixabayproject.databinding.FragmentSearchBinding
import com.example.tsoftmobilepixabayproject.viewmodel.PhotoListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {
    private var binding: FragmentSearchBinding? = null
    private var viewModel: PhotoListViewModel? = null
    private var adapter: PhotoListAdapter? = null
    private var _binding: FragmentHomeBinding? = null
    var mydata = arrayListOf<Hit>()

    private var apiKey = "28047783-b1ea0198798957e25a1771204"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)

        initViewModel()
        initObserver()
        viewModel?.downloadPhotos(apiKey)
        searchViewAction()
        return binding!!.root
    }


    fun searchViewAction() {
        binding?.search?.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(po: String?): Boolean {
                println("false")
                return false
            }

            override fun onQueryTextChange(po: String?): Boolean {
                println("true")
                notesFiltering(po)
                return true
            }
        })
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this@SearchFragment)[PhotoListViewModel::class.java]
    }

    private fun initObserver() {
        viewModel?.currentPhotoList?.observe(viewLifecycleOwner, Observer {
            initAdapter(it)
        })
    }

    private fun notesFiltering(po: String?) {
        val newFilteredList = arrayListOf<Hit>()
//For döngüsüne girmiyor
        for (f in mydata) {
            if (f.webformatURL.contains(po!!)) {

                newFilteredList.add(f)
                adapter?.filtering(newFilteredList)
            }


        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun initAdapter(photoList: List<Hit>) {
        adapter = PhotoListAdapter(photoList, object : PhotoListAdapter.ItemClickListener {
            override fun onClick(data: Hit) {

            }
        })
        binding?.photolistSearch?.adapter = adapter
        binding?.photolistSearch?.layoutManager = GridLayoutManager(requireContext(), 2)


    }


}