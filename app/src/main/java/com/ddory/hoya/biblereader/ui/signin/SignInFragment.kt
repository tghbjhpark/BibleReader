package com.ddory.hoya.biblereader.ui.signin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.ddory.hoya.biblereader.ViewModelFactory
import com.ddory.hoya.biblereader.databinding.SigninFragmentBinding

class SignInFragment :Fragment(){

    companion object {
        fun newInstance() = SignInFragment()
    }

    lateinit var binding: SigninFragmentBinding

    private val signInViewModel by viewModels<SignInViewModel> {
        ViewModelFactory(this, this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SigninFragmentBinding.inflate(inflater, container, false).apply {
            viewModel = signInViewModel
            lifecycleOwner = viewLifecycleOwner
        }
        binding.signInButton.setOnClickListener {
            signInViewModel.signIn()
        }
        lifecycle.addObserver(signInViewModel)
        return binding.root
    }
}
