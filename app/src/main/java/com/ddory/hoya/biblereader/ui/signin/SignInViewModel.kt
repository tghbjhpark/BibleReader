package com.ddory.hoya.biblereader.ui.signin

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import com.ddory.hoya.biblereader.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.util.concurrent.Executors

class SignInViewModel(fragment: Fragment) : ViewModel(), LifecycleObserver {

    private var auth: FirebaseAuth

    private var signInClient: GoogleSignInClient

    private var launcher: ActivityResultLauncher<Unit>

    private var executor = Executors.newSingleThreadExecutor()

    init {
        // Configure Google Sign In
        val context = fragment.requireContext()
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(context.getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        signInClient = GoogleSignIn.getClient(context, gso)

        // Initialize FirebaseAuth
        auth = Firebase.auth

        launcher = fragment.registerForActivityResult(SignInContract()) {
            firebaseAuthWithGoogle(it)
        }
    }

    fun signIn() {
        launcher.launch(Unit)
    }

    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount?) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct?.id)
        val credential = GoogleAuthProvider.getCredential(acct?.idToken, null)
        auth.signInWithCredential(credential)
            .addOnSuccessListener(Executors.newSingleThreadExecutor()) {
                Log.d(TAG, "signInWithCredential:success")
                // TODO :: move to next
            }
            .addOnFailureListener(Executors.newSingleThreadExecutor()) { e -> // If sign in fails, display a message to the user.
                Log.w(TAG, "signInWithCredential", e)
                // TODO :: show toast
            }
    }

    inner class SignInContract : ActivityResultContract<Unit, GoogleSignInAccount?>() {
        override fun createIntent(context: Context, input: Unit): Intent {
            return signInClient.signInIntent
        }

        override fun parseResult(resultCode: Int, intent: Intent?): GoogleSignInAccount? {
            val task = GoogleSignIn.getSignedInAccountFromIntent(intent)
            return try {
                task.getResult(ApiException::class.java)
            } catch (e: ApiException) {
                null
            }
        }
    }

    companion object {
        private const val TAG = "SignInViewModel"
    }
}
