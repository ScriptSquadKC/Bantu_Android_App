package com.example.bantu.data.Remote

import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
){

    suspend fun launchLogin(userName: String, password: String): String {
        var token = remoteDataSource.launchLogin(userName, password)

        if (token.isEmpty()) {
            return "Respository vacio"
        } else {
            return token
        }
    }


}