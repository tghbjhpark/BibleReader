package com.ddory.hoya.biblereader.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ddory.hoya.biblereader.ViewModelFactory
import com.ddory.hoya.biblereader.databinding.HomeFragmentBinding
import com.ddory.hoya.biblereader.ui.ActivityViewModel
import com.squareup.picasso.Picasso

class HomeFragment : Fragment() {

    lateinit var binding: HomeFragmentBinding

    private val homeViewModel by viewModels<HomeViewModel> {
        ViewModelFactory(this, this)
    }

    private val activityViewModel: ActivityViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = HomeFragmentBinding.inflate(inflater, container, false).apply {
            viewModel = homeViewModel
            lifecycleOwner = viewLifecycleOwner
        }
        lifecycle.addObserver(homeViewModel)
        activityViewModel.navigationEvent.observe(viewLifecycleOwner) {
            when (it) {
                ActivityViewModel.NavEvent.FRIENDS ->
                    findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToFriendsFragment())
                ActivityViewModel.NavEvent.SETTINGS ->
                    findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToSettingsFragment())
                else -> Unit
            }
        }
        homeViewModel.photoUrl.observe(viewLifecycleOwner) {
            Picasso.get()
                .load(it)
                .into(binding.homePhoto)
        }
        return binding.root
    }
}
