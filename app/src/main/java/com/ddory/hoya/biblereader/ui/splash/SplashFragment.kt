package com.ddory.hoya.biblereader.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.MaterialTheme
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ddory.hoya.biblereader.MainActivity
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
            lifecycleOwner = viewLifecycleOwner
        }.apply {
            this.composeSplashView.setContent {
                MaterialTheme {
                    SplashScreen()
                }
            }
        }
        lifecycle.addObserver(splashViewModel)
        initObserver()

        return binding.root
    }

    private fun initObserver() {
        splashViewModel.navigateTo.observe(viewLifecycleOwner) {
            when (it) {
                SplashViewModel.Direction.SIGN_IN ->
                    findNavController().navigate(
                        SplashFragmentDirections.actionSplashFragmentToSignInFragment()
                    )
                SplashViewModel.Direction.HOME -> {
                    (activity as MainActivity).enableBottomNavigation(true)
                    findNavController().navigate(
                        SplashFragmentDirections.actionSplashFragmentToHomeFragment()
                    )
                }
                else -> Unit
            }
        }
    }
}
