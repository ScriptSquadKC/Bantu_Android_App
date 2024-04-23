package com.example.bantu.ui.Home

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import com.example.bantu.ui.Home.HomePersonal.HomePersonalScreen
import com.example.bantu.ui.Home.HomePersonal.HomeProfesionalScreen

@Composable
fun HomeScreen(homeViewModel: HomeViewModel) {

    val state by homeViewModel.state.collectAsState()
    when (state) {
        is HomeState.Success -> {

            var user = (state as HomeState.Success).user

            Toast.makeText(LocalContext.current, "Success: ${user}", Toast.LENGTH_SHORT).show()
            Log.w("SUCCESS", user.toString())

            if (user.professional == null) {
                HomePersonalScreen(homeViewModel, user.name, user.photo)
            } else {
                HomeProfesionalScreen(homeViewModel)
            }

        }

        is HomeState.Error -> {

            var error = (state as HomeState.Error).error
            Log.w("ERROR", error)

        }

        else -> {}
    }


    //HomeProfesionalScreen(homeViewModel)
}