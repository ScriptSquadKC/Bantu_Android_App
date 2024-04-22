package com.example.bantu.Domain.Model

data class User (
    val name: String?,
    val email: String,
    val lastName1: String?,
    val lastName2: String?,
    val provinceId: Int?,
    val countryId: Int?,
    val city: String?,
    val postalCode: String?,
    val nickname: String?,
    val photo: String,
    val active: Boolean,
    val professional: Professional?,
)

