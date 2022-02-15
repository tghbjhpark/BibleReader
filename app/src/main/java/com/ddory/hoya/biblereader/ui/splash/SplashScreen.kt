package com.ddory.hoya.biblereader.ui.splash

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun SplashScreen(splashViewModel: SplashViewModel) {
    if (!splashViewModel.initialize) {
        splashViewModel.initialize()
    }
    Text(text = "SplashScreen")
}
