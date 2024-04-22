package com.example.bantu.Domain.Model

data class Professional (
    val description: String?,
    val telephone: String?,
    val nif: String?,
    val leavingDate: String?,
    val id: Int?,
    val pro_Type: Pro_Type?,
    val pro_Suscription: Pro_Suscription?,
    val pro_User: User?,


)

data class Pro_Type(
    val id: Int?,
    val type: String?,
    val active: Boolean?
)

data class Pro_Suscription(
    val suscription: String?,
    val active: Boolean?
)