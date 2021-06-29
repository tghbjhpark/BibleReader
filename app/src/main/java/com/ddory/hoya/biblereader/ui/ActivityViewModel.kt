package com.ddory.hoya.biblereader.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ActivityViewModel : ViewModel() {
    private val _navigationEvent = MutableLiveData<NavEvent>()
    val navigationEvent: LiveData<NavEvent>
        get() = _navigationEvent

    fun navigationEvent(event: NavEvent) = _navigationEvent.postValue(event)

    enum class NavEvent {
        HOME,
        FRIENDS,
        SETTINGS
    }
}
