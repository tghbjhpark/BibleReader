package com.ddory.hoya.biblereader.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ddory.hoya.biblereader.ViewModelFactory
import com.ddory.hoya.biblereader.databinding.SplashFragmentBinding

class SplashFragment : Fragment() {

    lateinit var binding: SplashFragmentBinding

    private val splashViewModel by viewModels<SplashViewModel> {
        ViewModelFactory(this, this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = SplashFragmentBinding.inflate(inflater, container, false).apply {
            viewModel = splashViewModel
            lifecycleOwner =viewLifecycleOwner
        }
        return binding.root
    }
}
