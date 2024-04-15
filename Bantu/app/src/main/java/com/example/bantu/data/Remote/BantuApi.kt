package com.example.bantu.data.Remote

import com.example.bantu.Domain.Model.AuthResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST


interface BantuApi {
    @FormUrlEncoded
    @POST("/api/auth/signin")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String,
        @Header("Authorization") credentials: String
    ): AuthResponse

}