package com.example.bantu.data.Remote

import com.example.bantu.Domain.Model.AuthResponse
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val bantuApi: BantuApi) {
    suspend fun launchLogin(emailField: String, passWord: String): AuthResponse {
        // Realiza la llamada de red utilizando la instancia de bantuApi
        val credentials = okhttp3.Credentials.basic(emailField, passWord)

        val response = bantuApi.login(emailField, passWord, credentials)
        return response
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
    ) {
        bantuApi.register(nickname, email, password, profesional, country, province, city, postal_code, first_name, last_name1, last_name2, photo)
    }

}


