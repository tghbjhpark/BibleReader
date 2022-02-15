package com.ddory.hoya.biblereader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ddory.hoya.biblereader.ui.main.MainApp
import com.ddory.hoya.biblereader.ui.splash.SplashScreen
import com.ddory.hoya.biblereader.ui.splash.SplashViewModel

class MainActivity : AppCompatActivity() {
    val splashViewModel by viewModels<SplashViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplashScreen(splashViewModel)
//            MainApp()
        }
    }
}
