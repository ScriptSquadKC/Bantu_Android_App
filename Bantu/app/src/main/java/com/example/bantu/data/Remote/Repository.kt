package com.example.bantu.data.Remote

import com.example.bantu.AppClass
import com.example.bantu.di.ACCESS_TOKEN
import com.example.bantu.di.REFRESH_TOKEN
import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
){

    suspend fun launchLogin(userName: String, password: String): String {
        var token = remoteDataSource.launchLogin(userName, password)

        AppClass.prefRepository.saveTokenPreferences(ACCESS_TOKEN,token.accesToken)//SALVO TOKEN EN PREFERENCES
        AppClass.prefRepository.saveTokenPreferences(REFRESH_TOKEN,token.refreshToken)//SALVO TOKEN EN PREFERENCES

        if (token.accesToken.isEmpty()) {
            return "Respository vacio"
        } else {
            return token.accesToken
        }
    }


}