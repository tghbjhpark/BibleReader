package com.ddory.hoya.biblereader.model.repository

import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

object Repository {

    private val uid: String by lazy {
        Firebase.auth.uid ?: throw IllegalStateException("Firebase auth is null")
    }

    private val database = Firebase.database.reference

    fun loadCloudData() {
        database.child(READ_COUNT).child(uid).get()
            .addOnSuccessListener {
                if (it.value == null) createReadedCount()
            }
    }

    private fun createReadedCount() {
        database.child(READ_COUNT).child(uid).setValue(0)
    }

    private const val READ_COUNT = "readcount"
}