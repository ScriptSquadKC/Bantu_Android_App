package com.example.bantu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.bantu.ui.Login.LoginScreen
import com.example.bantu.ui.Register.RegisterScreen
import com.example.bantu.ui.theme.BantuTheme

class MainActivity : ComponentActivity() {

    var name = "Wellcome Back"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BantuTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen(name)
                }
            }
        }
    }
}

