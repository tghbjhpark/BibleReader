package com.ddory.hoya.biblereader.ui.signin

import android.content.Context
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import com.ddory.hoya.biblereader.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignInViewModel(context: Context) : ViewModel(), LifecycleObserver {

    private var auth: FirebaseAuth

    private var signInClient: GoogleSignInClient

    init {
        // Configure Google Sign In
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(context.getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        signInClient = GoogleSignIn.getClient(context, gso)

        // Initialize FirebaseAuth
        auth = Firebase.auth
    }
}
