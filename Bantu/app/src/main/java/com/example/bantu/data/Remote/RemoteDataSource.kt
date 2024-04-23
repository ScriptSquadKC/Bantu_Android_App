package com.example.bantu.data.Remote

import android.util.Log
import com.example.bantu.Domain.Model.AuthResponse
import com.example.bantu.Domain.Model.User
import com.example.bantu.Domain.Model.UserRequest
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val bantuApi: BantuApi) {
    suspend fun launchLogin(emailField: String, passWord: String): AuthResponse {

        val credentials = okhttp3.Credentials.basic(emailField, passWord)
        Log.w("ERROR credentiasl", credentials)

        val response = bantuApi.login(emailField, passWord, credentials)
        return response
    }

    suspend fun launchRegister(
        nickname: String,
        email: String,
        password: String,
        profesional: String,
    ) {
        bantuApi.register(nickname, email, password, profesional)
    }

    suspend fun getUserById(userId: String): User {
        return bantuApi.getUser(userId)
    }

}



