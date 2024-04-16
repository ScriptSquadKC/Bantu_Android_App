package com.example.bantu.ui.Login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bantu.AppClass
import com.example.bantu.ui.theme.BantuTheme
import dagger.hilt.android.AndroidEntryPoint
import com.example.bantu.di.ACCESS_TOKEN
import com.example.bantu.ui.Home.HomeActivity
import com.example.bantu.ui.Login.LoginView.LoginState
import com.example.bantu.ui.Login.LoginView.LoginViewModel
import com.example.bantu.ui.Login.LoginView.LoginViewScreen
import com.example.bantu.ui.Login.RegisterView.RegisterScreen


@AndroidEntryPoint
class LoginActivity : ComponentActivity() {
    var token = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val loginViewModel by viewModels<LoginViewModel> ()
        setContent {
            BantuTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "Login") {

                        composable("Login") {

                            if (AppClass.prefRepository.loadTokenPreferences(ACCESS_TOKEN).isEmpty()){
                                LoginViewScreen(loginViewModel, navController)
                                LoginScreen(loginViewModel)
                            }else{

                                val intent = Intent(LocalContext.current, HomeActivity::class.java)
                                LocalContext.current.startActivity(intent)
                                (LocalContext.current as? Activity)?.finish()
                            }

                        }

                        composable("Register") {

                        RegisterScreen()

                        }


                    }



                }
            }
        }
    }
}


@Composable
fun LoginScreen(loginViewModel: LoginViewModel){
    val state by loginViewModel.state.collectAsState()

    LaunchedEffect(state) {
    }


    when (state) {
        is LoginState.Success -> {
            val token = (state as LoginState.Success).token
            val intent = Intent(LocalContext.current, HomeActivity::class.java)
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