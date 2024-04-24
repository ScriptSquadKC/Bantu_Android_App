package com.example.bantu.ui.Login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bantu.AppClass
import com.example.bantu.R
import com.example.bantu.ui.theme.BantuTheme
import dagger.hilt.android.AndroidEntryPoint
import com.example.bantu.di.ACCESS_TOKEN
import com.example.bantu.ui.Home.HomeActivity
import com.example.bantu.ui.Login.LoginView.LoginState
import com.example.bantu.ui.Login.LoginView.LoginViewModel
import com.example.bantu.ui.Login.LoginView.LoginViewScreen
import com.example.bantu.ui.Login.RegisterView.RegisterViewModel
import com.example.bantu.ui.Login.RegisterView.RegisterViewScreen


@AndroidEntryPoint
class LoginActivity : ComponentActivity() {
    val loginViewModel by viewModels<LoginViewModel> ()
    val registerViewModel by viewModels<RegisterViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BantuTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = colorResource(id = R.color.backgroud_light)) {
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "Login") {

                        composable("Login") {

                            if (AppClass.prefRepository.loadTokenPreferences(ACCESS_TOKEN).isEmpty()){
                                LoginViewScreen(
                                    loginViewModel,
                                    navController
                                )
                                LoginScreen(loginViewModel)
                            }else{

                                val intent = Intent(LocalContext.current, HomeActivity::class.java)
                                LocalContext.current.startActivity(intent)
                                (LocalContext.current as? Activity)?.finish()
                            }

                        }

                        composable("RegisterRoute") {

                            RegisterViewScreen(registerViewModel)

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
            val token = (state as LoginState.Success).responseLogin
            val intent = Intent(LocalContext.current, HomeActivity::class.java)
            LocalContext.current.startActivity(intent)
            (LocalContext.current as? Activity)?.finish()
        }
        is LoginState.Idle ->
            Text("")

        is LoginState.Error -> {
            val error = (state as LoginState.Error).error

            when {
                error == "HTTP 401 " -> {
                    // Mostrar un Toast indicando que el usuario o la contraseña son incorrectos
                    Toast.makeText(LocalContext.current, "Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show()
                    Log.w("error", error)
                }
                error == "HTTP 404 " -> {
                    // Mostrar un Toast indicando que la página no se encontró
                    Toast.makeText(LocalContext.current, "Página no encontrada", Toast.LENGTH_SHORT).show()
                    Log.w("error", error)
                }
                error == "HTTP 500 " -> {
                    // Mostrar un Toast indicando un error interno del servidor
                    Toast.makeText(LocalContext.current, "Error interno del servidor", Toast.LENGTH_SHORT).show()
                    Log.w("error", error)
                }
                error == "Network Error" -> {
                    // Mostrar un Toast indicando un error de red
                    Toast.makeText(LocalContext.current, "Error de red", Toast.LENGTH_SHORT).show()
                    Log.w("error", error)
                }
                // Agregar más casos de error según sea necesario
                else -> {
                    // Manejar otros casos de error
                    Log.w("error", "Error desconocido: $error")
                }
            }
        }
    }

}

