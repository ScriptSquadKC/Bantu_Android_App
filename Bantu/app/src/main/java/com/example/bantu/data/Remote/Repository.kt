package com.example.bantu.data.Remote

import com.example.bantu.AppClass
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
            return response.accesToken
        }
    }

    suspend fun launchRegister(
        nickname: String,
        email: String,
        password: String,
        profesional: String,
        country: String,
        province: String,
        city: String,
        postal_code: String,
        first_name: String,
        last_name1: String,
        last_name2: String,
        photo: String,
    ){
        remoteDataSource.launchRegister(nickname,email, password, profesional, country, province, city, postal_code, first_name, last_name1, last_name2, photo)

    }


}

