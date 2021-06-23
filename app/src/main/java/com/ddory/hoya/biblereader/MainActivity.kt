package com.ddory.hoya.biblereader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.ddory.hoya.biblereader.ui.main.MainFragment
import com.ddory.hoya.biblereader.ui.signin.SignInFragment
import com.ddory.hoya.biblereader.ui.splash.SplashFragmentDirections
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

//        auth = Firebase.auth
//        if (auth.currentUser == null) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.container, SignInFragment.newInstance())
//                .commitNow()
//        } else {
//            bottom_navigation.visibility = View.VISIBLE
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.container, MainFragment.newInstance())
//                .commitNow()
//        }
    }

    fun enableBottomNavigation(isEnable: Boolean) {
        bottom_navigation.visibility = if (isEnable) View.VISIBLE else View.GONE
    }
}