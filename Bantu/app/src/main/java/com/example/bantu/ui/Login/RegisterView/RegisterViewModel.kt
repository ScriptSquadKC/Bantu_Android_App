package com.example.bantu.ui.Login.RegisterView

import android.provider.ContactsContract.CommonDataKinds.Nickname
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
class RegisterViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    private val _state: MutableStateFlow<RegisterState> = MutableStateFlow(RegisterState.Idle)
    val state: StateFlow<RegisterState> = _state.asStateFlow()



    fun launchRegister(
        nickname: String,
        email: String,
        password: String,
        profesional: String,


    ) {
        viewModelScope.launch {
            _state.update { RegisterState.Idle }

            val token = runCatching {
                withContext(Dispatchers.IO) {
                    repository.launchRegister(
                        nickname,
                        email,
                        password,
                        profesional
                    )


                }
            }
            if (token.isSuccess) {
                _state.update { RegisterState.Success}
            } else {
                _state.update { RegisterState.Error(token.exceptionOrNull()?.message.orEmpty()) }
            }

        }
    }
}