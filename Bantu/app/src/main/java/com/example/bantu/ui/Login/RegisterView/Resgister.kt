package com.example.bantu.ui.Login.RegisterView

sealed class ResgisterState {
    data class Success(val token: String) : ResgisterState()

    object Idle : ResgisterState()
    data class Error(val error: String) : ResgisterState()
}