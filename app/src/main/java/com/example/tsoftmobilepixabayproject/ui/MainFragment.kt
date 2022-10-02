package com.example.tsoftmobilepixabayproject.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.tsoftmobilepixabayproject.R
import com.example.tsoftmobilepixabayproject.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentMainBinding.inflate(inflater, container, false)

        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> {
                    childFragmentManager.primaryNavigationFragment?.findNavController()
                        ?.navigate(R.id.homeFragment)
                }
                R.id.nav_search -> {
                    childFragmentManager.primaryNavigationFragment?.findNavController()
                        ?.navigate(R.id.searchFragment)
                }
                R.id.nav_favorite -> {
                    childFragmentManager.primaryNavigationFragment?.findNavController()
                        ?.navigate(R.id.favoriteFragment)
                }


            }
            true
        }
        return binding.root
    }


}