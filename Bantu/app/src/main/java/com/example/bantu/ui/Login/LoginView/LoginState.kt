package com.example.bantu.ui.Login.LoginView

sealed class LoginState {
    data class Success(val token: String) : LoginState()

    object Idle : LoginState()
    data class Error(val error: String) : LoginState()
}