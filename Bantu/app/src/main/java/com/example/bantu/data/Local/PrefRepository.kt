package com.example.bantu.data.Local

import android.content.Context

class PrefRepository(val context: Context) {

    val SHARED_NAME = "Mydtb"



    private val storage = context.getSharedPreferences(SHARED_NAME, 0)

    fun saveTokenPreferences(name: String, value: String) {
        storage.edit().putString(name, value).apply()
    }

    fun loadTokenPreferences(name: String): String {
        return storage.getString(name, "")!!
    }


}