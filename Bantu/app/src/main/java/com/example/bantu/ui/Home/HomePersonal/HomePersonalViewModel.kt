package com.example.bantu.ui.Home.HomePersonal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bantu.data.Remote.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.example.bantu.AppClass
import com.example.bantu.data.Local.PrefRepository
import kotlinx.coroutines.launch

@HiltViewModel
class HomePersonalViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {


}
