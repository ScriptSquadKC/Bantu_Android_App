package com.example.bantu.ui.Login.LoginView

import com.example.bantu.Domain.Model.AuthResponse

sealed class LoginState {
    data class Success(val login: String) : LoginState()

    object Idle : LoginState()
    data class Error(val error: String) : LoginState()
}