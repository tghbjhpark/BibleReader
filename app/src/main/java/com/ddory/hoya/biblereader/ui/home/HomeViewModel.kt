package com.ddory.hoya.biblereader.ui.home

import androidx.lifecycle.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class HomeViewModel : ViewModel(), LifecycleObserver {

    private val _photoUrl = MutableLiveData<String>()
    val photoUrl: LiveData<String>
        get() = _photoUrl

    private val _displayName = MutableLiveData<String>()
    val displayName: LiveData<String>
        get() = _displayName

    private lateinit var auth: FirebaseAuth

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        auth = Firebase.auth

        auth.currentUser?.let {
            _photoUrl.postValue(it.photoUrl?.toString().orEmpty())
            _displayName.postValue(it.displayName.orEmpty())
        }
    }
}
