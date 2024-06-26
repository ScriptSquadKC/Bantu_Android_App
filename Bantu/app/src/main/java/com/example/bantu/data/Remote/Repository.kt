package com.example.bantu.data.Remote

import com.example.bantu.AppClass
import com.example.bantu.Domain.Model.AuthResponse
import com.example.bantu.Domain.Model.User
import com.example.bantu.di.ACCESS_TOKEN
import com.example.bantu.di.ID_USER
import com.example.bantu.di.REFRESH_TOKEN
import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
){

    suspend fun launchLogin(userName: String, password: String): String {
        var response = remoteDataSource.launchLogin(userName, password)

        AppClass.prefRepository.saveTokenPreferences(ACCESS_TOKEN,response.accesToken)//SALVO TOKEN EN PREFERENCES
        AppClass.prefRepository.saveTokenPreferences(REFRESH_TOKEN,response.refreshToken)//SALVO TOKEN EN PREFERENCES
        AppClass.prefRepository.saveTokenPreferences(ID_USER,response.userId.toString())//SALVO TOKEN EN PREFERENCES

        if (response.accesToken.isEmpty()) {
            return "Respository vacio"
        } else {
            return "Ok login"
        }
    }

    suspend fun launchRegister(
        nickname: String,
        email: String,
        password: String,
        profesional: String,


    ){
        remoteDataSource.launchRegister(nickname,email, password, profesional)

    }

    suspend fun getUserById(userId: String, token: String): User {
        val response = remoteDataSource.getUserById(userId)
        return response
    }


   suspend fun clearPreferences(){
       AppClass.prefRepository.clearPreferences()
   }


}

