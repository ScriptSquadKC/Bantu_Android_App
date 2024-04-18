package com.example.bantu.Domain.Model

import com.squareup.moshi.Json

data class AuthResponse(
    @Json(name = "refreshToken") val refreshToken: String,
    @Json(name = "userId") val userId: Int,
    @Json(name = "accesToken") val accesToken: String,
)

/*
{
    "refreshToken": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3OTk2MDU0ODEuNTQ3NDQ1LCJ0eXBlIjoicmVmcmVzaCIsInN1YiI6IjIifQ.-NkyN6pRj-Xu0j5R0SCWD807WxXZOQy4xGboTggrA2k",
    "accesToken": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTUwMDU0ODEuNTQ3NDQzLCJ0eXBlIjoiYWNlc3MiLCJzdWIiOiIyIn0.6iQG8aykTQ6fCEQlldfgeIKsLxvVikOrhTQW4suk7cQ"
}
 */