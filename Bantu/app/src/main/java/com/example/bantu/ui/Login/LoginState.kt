package com.example.bantu.ui.Login

sealed class LoginState {
    data class Success(val token: String) : LoginState()

    object Idle : LoginState()
    data class Error(val error: String) : LoginState()
}