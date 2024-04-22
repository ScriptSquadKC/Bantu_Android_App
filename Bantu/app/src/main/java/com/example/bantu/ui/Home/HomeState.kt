package com.example.bantu.ui.Home

import com.example.bantu.Domain.Model.User

sealed class HomeState {
    data class Success(val user: User) : HomeState()

    object Idle : HomeState()
    data class Error(val error: String) : HomeState()
}