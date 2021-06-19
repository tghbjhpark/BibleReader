package com.ddory.hoya.biblereader.ui.friends

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ddory.hoya.biblereader.ViewModelFactory
import com.ddory.hoya.biblereader.databinding.FriendsFragmentBinding

class FriendsFragment : Fragment() {

    lateinit var binding: FriendsFragmentBinding

    private val friendsViewModel by viewModels<FriendsViewModel> {
        ViewModelFactory(this, this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FriendsFragmentBinding.inflate(inflater, container, false).apply {
            viewModel = friendsViewModel
            lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }
}