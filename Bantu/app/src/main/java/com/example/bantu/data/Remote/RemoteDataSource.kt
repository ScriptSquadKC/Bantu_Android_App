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
    ) {
        bantuApi.register(nickname, email, password, profesional )
    }

}


