package com.ddory.hoya.biblereader.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ddory.hoya.biblereader.MainActivity
import com.ddory.hoya.biblereader.ViewModelFactory
import com.ddory.hoya.biblereader.databinding.SplashFragmentBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.main_activity.*

class SplashFragment : Fragment() {

    private lateinit var auth: FirebaseAuth

    lateinit var binding: SplashFragmentBinding

    private val splashViewModel by viewModels<SplashViewModel> {
        ViewModelFactory(this, this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = SplashFragmentBinding.inflate(inflater, container, false).apply {
            viewModel = splashViewModel
            lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = Firebase.auth
        if (auth.currentUser == null) {
            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToSignInFragment())

        } else {
            (activity as MainActivity).enableBottomNavigation(true)
            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToHomeFragment())
        }
    }
}
