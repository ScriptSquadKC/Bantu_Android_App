package com.example.bantu.ui.Home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.example.bantu.R
import com.example.bantu.ui.Home.HomePersonal.HomePersonalScreen
import com.example.bantu.ui.Home.HomePersonal.HomePersonalViewModel
import com.example.bantu.ui.Home.HomePersonal.HomeProfesionalScreen
import com.example.bantu.ui.Home.HomeProfesional.HomeProfesionalViewModel
import com.example.bantu.ui.theme.BantuTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity: ComponentActivity() {
    val homePersonalViewModel by viewModels<HomePersonalViewModel> ()
    val homeProfesionalViewModel by viewModels<HomeProfesionalViewModel> ()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            BantuTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = colorResource(id = R.color.backgroud_dark)) {

                    HomePersonalScreen(homePersonalViewModel)
                    //HomeProfesionalScreen(homeProfesionalViewModel)

                }
            }
        }
    }
}