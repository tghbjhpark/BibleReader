package com.ddory.hoya.biblereader

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.ddory.hoya.biblereader.ui.friends.FriendsViewModel
import com.ddory.hoya.biblereader.ui.home.HomeViewModel
import com.ddory.hoya.biblereader.ui.settings.SettingsViewModel
import com.ddory.hoya.biblereader.ui.signin.SignInViewModel
import com.ddory.hoya.biblereader.ui.splash.SplashViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory constructor(
    private val fragment: Fragment,
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle? = null
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {
    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T = with(modelClass) {
        when {
            isAssignableFrom(SignInViewModel::class.java) ->
                SignInViewModel(fragment)
            isAssignableFrom(SplashViewModel::class.java) ->
                SplashViewModel()
            isAssignableFrom(HomeViewModel::class.java) ->
                HomeViewModel()
            isAssignableFrom(FriendsViewModel::class.java) ->
                FriendsViewModel()
            isAssignableFrom(SettingsViewModel::class.java) ->
                SettingsViewModel()
            else ->
                throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    } as T
}
