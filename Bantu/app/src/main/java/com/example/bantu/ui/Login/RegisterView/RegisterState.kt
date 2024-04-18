package com.example.bantu.ui.Login.RegisterView

sealed class RegisterState {
    object Success : RegisterState()

    object Idle : RegisterState()
    data class Error(val error: String) : RegisterState()
}