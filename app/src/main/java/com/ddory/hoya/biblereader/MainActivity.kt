package com.ddory.hoya.biblereader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ddory.hoya.biblereader.ui.main.MainFragment
import com.ddory.hoya.biblereader.ui.signin.SignInFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        auth = Firebase.auth
        if (auth.currentUser == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SignInFragment.newInstance())
                .commitNow()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}