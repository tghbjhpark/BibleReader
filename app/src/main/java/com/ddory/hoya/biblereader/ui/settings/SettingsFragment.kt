package com.ddory.hoya.biblereader.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ddory.hoya.biblereader.ViewModelFactory
import com.ddory.hoya.biblereader.databinding.SettingsFragmentBinding

class SettingsFragment : Fragment() {

    lateinit var binding: SettingsFragmentBinding

    private val settingsViewModel by viewModels<SettingsViewModel> {
        ViewModelFactory(this, this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = SettingsFragmentBinding.inflate(inflater, container, false).apply {
            viewModel = settingsViewModel
            lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }
}
