package com.example.bantu.ui.Login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.bantu.ui.theme.BantuTheme
import dagger.hilt.android.AndroidEntryPoint
import com.example.bantu.AppClass.Companion.prefRepository
import com.example.bantu.di.ACCESS_TOKEN
import com.example.bantu.ui.Home.HomeViewActivity

@AndroidEntryPoint
class   LoginViewActivity : ComponentActivity() {
    var token = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val loginViewModel by viewModels<LoginViewModel> ()
        setContent {
            BantuTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {

                    LoginViewScreen(loginViewModel)
                    LoginScreen(loginViewModel)
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(loginViewModel: LoginViewModel ){
    val state by loginViewModel.state.collectAsState()

    LaunchedEffect(state) {
    }


    when (state) {
        is LoginState.Success -> {
            val token = (state as LoginState.Success).token
            prefRepository.saveTokenPreferences(ACCESS_TOKEN,token)//SALVO TOKEN EN PREFERENCES
            val intent = Intent(LocalContext.current, HomeViewActivity::class.java)
            LocalContext.current.startActivity(intent)
            (LocalContext.current as? Activity)?.finish()


        }
        is LoginState.Idle ->
            Text("")

        is LoginState.Error -> {
            val error = (state as LoginState.Error).error
            Text("Error: $error")
        }
    }
}