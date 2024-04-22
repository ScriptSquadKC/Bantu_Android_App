package com.example.bantu.data.Remote

import com.example.bantu.Domain.Model.AuthResponse
import com.example.bantu.Domain.Model.User
import com.example.bantu.Domain.Model.UserRequest
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path


interface BantuApi {

    @FormUrlEncoded
    @POST("/api/auth/signin")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String,
        @Header("Authorization") credentials: String
    ): AuthResponse

    @FormUrlEncoded
    @POST("/api/auth/signup")
    suspend fun register(
        @Field("nickname") nickname: String?,
        @Field("email") email: String,
        @Field("password") password: String?,
        @Field("profesional") profesional: String?,
    )

    @GET("/api/users/{id}")
    suspend fun getUser(
        @Path("id") id:String,
        @Header("Authorization\", \"Bearer \" + token") token: String

    ): User


}

