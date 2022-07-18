package com.ddory.hoya.biblereader.ui.splash

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.*
import com.ddory.hoya.biblereader.model.repository.Repository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import java.util.concurrent.Executors

class SplashViewModel : ViewModel() {

    var initialize by mutableStateOf(false)
        private set

    var navigateTo by mutableStateOf(Direction.UNKNOWN)
        private set

    private lateinit var auth: FirebaseAuth

    private lateinit var remoteConfig: FirebaseRemoteConfig

    fun initialize() {
        Log.i("JONGHO", "initialize")
        initRemoteConfig()
        getConfigFetch()
    }

    private fun initRemoteConfig() {
        remoteConfig = Firebase.remoteConfig
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = ONE_DAY_SECONDS
        }
        remoteConfig.setConfigSettingsAsync(configSettings)
    }

    private fun getConfigFetch() {
        remoteConfig.fetchAndActivate()
            .addOnCompleteListener(Executors.newSingleThreadExecutor()) { task ->
                if (task.isSuccessful) {
                    val version = remoteConfig.getString(KEY_CONFIG_LATEST_VERSION)
                    Log.i(TAG, version)
                } else {
                    Log.i(TAG, "failed")
                }
                initialize = true
                navigateToNext()
            }
    }

    private fun navigateToNext() {
        auth = Firebase.auth
        if (auth.currentUser == null) {
            navigateTo = Direction.SIGN_IN
        } else {
            loadCloudData()
            navigateTo = Direction.HOME
        }
    }

    private fun loadCloudData() {
        Repository.loadCloudData()
    }

    enum class Direction {
        UNKNOWN,
        SIGN_IN,
        HOME
    }

    companion object {
        private const val TAG = "SplashViewModel"

        private const val ONE_DAY_SECONDS = 86400L
        private const val KEY_CONFIG_LATEST_VERSION = "latest_version"
    }
}
