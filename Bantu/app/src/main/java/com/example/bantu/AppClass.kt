package com.example.bantu

import android.annotation.SuppressLint
import android.app.Application
import com.example.bantu.data.Local.PrefRepository
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AppClass: Application() {

    companion object{
        @SuppressLint("StaticFieldLeak")
        lateinit var prefRepository: PrefRepository
    }

    override fun onCreate() {
        super.onCreate()
        prefRepository = PrefRepository(applicationContext)
    }
}