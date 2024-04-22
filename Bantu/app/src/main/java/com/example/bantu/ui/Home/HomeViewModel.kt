package com.example.bantu.ui.Home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bantu.AppClass
import com.example.bantu.data.Remote.Repository
import com.example.bantu.di.ACCESS_TOKEN
import com.example.bantu.di.ID_USER
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
class HomeViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    private val _state: MutableStateFlow<HomeState> = MutableStateFlow(HomeState.Idle)
    val state: StateFlow<HomeState> = _state.asStateFlow()

    fun clearPreferences() {
        viewModelScope.launch {
            repository.clearPreferences()
        }
    }

    fun getUserById(){

        viewModelScope.launch {
            _state.update { HomeState.Idle }

            val user = runCatching {
                withContext(Dispatchers.IO) {
                    repository.getUserById(AppClass.prefRepository.loadTokenPreferences(ID_USER),AppClass.prefRepository.loadTokenPreferences(ACCESS_TOKEN))
                }
            }
            if (user.isSuccess) {
                _state.update { HomeState.Success(user.getOrThrow()) }
            } else {
                _state.update { HomeState.Error(user.exceptionOrNull()?.message.orEmpty()) }
            }
        }
    }


}
