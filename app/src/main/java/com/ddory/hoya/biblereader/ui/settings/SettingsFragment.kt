package com.ddory.hoya.biblereader.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ddory.hoya.biblereader.ViewModelFactory
import com.ddory.hoya.biblereader.databinding.SettingsFragmentBinding
import com.ddory.hoya.biblereader.ui.ActivityViewModel
import com.ddory.hoya.biblereader.ui.home.HomeFragmentDirections

class SettingsFragment : Fragment() {

    lateinit var binding: SettingsFragmentBinding

    private val settingsViewModel by viewModels<SettingsViewModel> {
        ViewModelFactory(this, this)
    }

    private val activityViewModel: ActivityViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = SettingsFragmentBinding.inflate(inflater, container, false).apply {
            viewModel = settingsViewModel
            lifecycleOwner = viewLifecycleOwner
        }
        activityViewModel.navigationEvent.observe(viewLifecycleOwner) {
            when (it) {
                ActivityViewModel.NavEvent.HOME ->
                    findNavController().navigate(SettingsFragmentDirections.actionSettingsFragmentToHomeFragment())
                ActivityViewModel.NavEvent.FRIENDS ->
                    findNavController().navigate(SettingsFragmentDirections.actionSettingsFragmentToFriendsFragment())
                else -> Unit
            }
        }
        return binding.root
    }
}
