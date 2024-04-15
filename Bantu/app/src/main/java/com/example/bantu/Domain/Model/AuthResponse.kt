package com.example.bantu.Domain.Model

import com.squareup.moshi.Json

data class AuthResponse(
    @Json(name = "refreshToken") val refreshToken: String,
    @Json(name = "accesToken") val accesToken: String,
)