package com.ddory.hoya.biblereader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ddory.hoya.biblereader.ui.home.HomeScreen
import com.ddory.hoya.biblereader.ui.main.MainApp
import com.ddory.hoya.biblereader.ui.splash.SplashScreen
import com.ddory.hoya.biblereader.ui.splash.SplashViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    val splashViewModel by viewModels<SplashViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        var uiState: Boolean by mutableStateOf(true)

        lifecycleScope.launch {
            delay(3000L)
            uiState = false
        }
        splashScreen.setKeepOnScreenCondition {
            uiState
        }
        setContent {
//            SplashActivityScreen()
//            MainApp()
            HomeScreen()
        }
    }
}

@Composable
fun SplashActivityScreen() {
    SplashScreen()
}
