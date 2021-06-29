package com.ddory.hoya.biblereader.ui.friends

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ddory.hoya.biblereader.ViewModelFactory
import com.ddory.hoya.biblereader.databinding.FriendsFragmentBinding
import com.ddory.hoya.biblereader.ui.ActivityViewModel
import com.ddory.hoya.biblereader.ui.home.HomeFragmentDirections

class FriendsFragment : Fragment() {

    lateinit var binding: FriendsFragmentBinding

    private val friendsViewModel by viewModels<FriendsViewModel> {
        ViewModelFactory(this, this)
    }

    private val activityViewModel: ActivityViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FriendsFragmentBinding.inflate(inflater, container, false).apply {
            viewModel = friendsViewModel
            lifecycleOwner = viewLifecycleOwner
        }
        activityViewModel.navigationEvent.observe(viewLifecycleOwner) {
            when (it) {
                ActivityViewModel.NavEvent.HOME ->
                    findNavController().navigate(FriendsFragmentDirections.actionFriendsFragmentToHomeFragment())
                ActivityViewModel.NavEvent.SETTINGS ->
                    findNavController().navigate(FriendsFragmentDirections.actionFriendsFragmentToSettingsFragment())
                else -> Unit
            }
        }
        return binding.root
    }
}