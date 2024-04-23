package com.example.bantu.ui.Home

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import com.example.bantu.data.Remote.Repository
import com.example.bantu.ui.Home.HomePersonal.HomePersonalScreen
import com.example.bantu.ui.Home.HomePersonal.HomePersonalViewModel
import com.example.bantu.ui.Home.HomePersonal.HomeProfesionalScreen
import com.example.bantu.ui.Home.HomeProfesional.HomeProfesionalViewModel

@Composable
fun HomeScreen (homeViewModel: HomeViewModel){

    val state by homeViewModel.state.collectAsState()
    when(state){
        is HomeState.Success ->{

            var user = (state as HomeState.Success).user
            Toast.makeText(LocalContext.current, "Success: ${user}", Toast.LENGTH_SHORT).show()
            Log.w("SUCCESS", user.toString())

            var isProfesional = user.professional?.nif.toString()

            if(isProfesional.isEmpty()){
                HomePersonalScreen(homeViewModel)
            }else{
                HomeProfesionalScreen(homeViewModel)
            }

            }

        is  HomeState.Error -> {

            var error = (state as HomeState.Error).error
            Log.w("ERROR",error)
            Toast.makeText(LocalContext.current, "Error: $error", Toast.LENGTH_SHORT).show()


        }

        else -> {}
    }


    //HomeProfesionalScreen(homeViewModel)
}