package com.example.bantu.data.Remote

import com.example.bantu.Domain.Model.AuthResponse
import com.example.bantu.di.NetworkLogin
import com.example.bantu.di.NetworkModule
import javax.inject.Inject

class RemoteDataSource@Inject constructor(
    private val networkLogin: NetworkLogin
){


        suspend fun launchLogin(userName: String, password: String): String {
            return networkLogin.launchLogin(userName,password)
        }
}

