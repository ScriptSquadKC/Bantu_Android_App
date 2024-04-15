package com.example.bantu.di

import android.util.Log
import com.example.bantu.AppClass.Companion.prefRepository
import com.example.bantu.Domain.Model.AuthResponse
import com.example.bantu.data.Remote.BantuApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
class NetworkLogin @Inject constructor(){

    private val BASE_URL = "https://bantubackend-dev-tnqr.2.ie-1.fl0.io"
    private var accessToken : String = ""
    private var refreshToken: String = ""

    @Provides
    suspend fun launchLogin(emailField: String, passWord: String): String {

        try {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build()

            val bantuApiLogin = retrofit.create(BantuApi::class.java)

            val credentials = okhttp3.Credentials.basic(emailField, passWord)

            val response = bantuApiLogin.login(emailField, passWord, credentials)

            Log.e("RESPONSE", response.accesToken)
            accessToken = response.accesToken
            refreshToken = response.refreshToken

            prefRepository.saveTokenPreferences(ACCESS_TOKEN,accessToken)//SALVO TOKEN EN PREFERENCES
            prefRepository.saveTokenPreferences(REFRESH_TOKEN,refreshToken)//SALVO TOKEN EN PREFERENCES


        } catch (e: Exception) {
            // Manejar errores
            Log.e("RESPONSE", "Error durante la solicitud: ${e.message}")
        }
        Log.e("hola", accessToken)
        return accessToken
    }

}