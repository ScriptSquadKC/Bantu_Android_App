package com.example.bantu.ui.Login.LoginView

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bantu.data.Remote.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    private val _state: MutableStateFlow<LoginState> = MutableStateFlow(LoginState.Idle)
    val state: StateFlow<LoginState> = _state.asStateFlow()



    fun launchLogin(userName: String, password: String) {
        viewModelScope.launch {
            _state.update { LoginState.Idle }

            val token = runCatching {
                withContext(Dispatchers.IO) {
                    repository.launchLogin(userName, password)
                }
            }
            if (token.isSuccess) {
                _state.update { LoginState.Success(token.getOrThrow()) }
            } else {
                _state.update { LoginState.Error(token.exceptionOrNull()?.message.orEmpty()) }
            }

        }
    }
}

