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

    @FormUrlEncoded
    @POST("/api/auth/signup")
    suspend fun register(
        @Field("nickname") nickname: String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("profesional") profesional: String,
        @Field("countryId") countryId: String?,
        @Field("provinceId") provinceId: String?,
        @Field("city") city: String?,
        @Field("postalCode") postal_code: String?,
        @Field("first_name") first_name: String?,
        @Field("lastName1") lastName1: String,
        @Field("lastName2") lastName2: String,
        @Field("photo") photo: String,


    )

}