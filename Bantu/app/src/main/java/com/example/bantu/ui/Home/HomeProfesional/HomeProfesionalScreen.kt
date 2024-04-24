package com.example.bantu.ui.Home.HomePersonal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bantu.R
import com.example.bantu.ui.Components.BotomBar
import com.example.bantu.ui.Components.ImageHomeComponent
import com.example.bantu.ui.Components.Toolbar
import com.example.bantu.ui.Home.HomeProfesional.HomeProfesionalViewModel
import com.example.bantu.ui.Home.HomeViewModel


@Composable
fun HomeProfesionalScreen(
   homeViewModel: HomeViewModel,
    name: String?,
    photo: String?
) {

    Scaffold(
        topBar = {
            Toolbar(
                homeViewModel,
                name,
                photo
            )
        },
        content = { paddingValues ->
            ContentPro(
                modifier = Modifier.padding(paddingValues)
            )
        },
        bottomBar = { BotomBar() }
    )

}


@Composable
fun ContentPro(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .then(modifier)

    ) {
        Column {
            LazyColumn(
                modifier = Modifier.padding(20.dp, 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                item {
                    ImageHomeComponent(
                        id = R.drawable.create_rutines,
                        text = stringResource(R.string.CREATE_RUTINES),
                        width = 350,
                        height = 150,
                        onClick = { /* Acción cuando se hace clic en el botón */ }
                    )
                }
                item {
                    Spacer(modifier = Modifier.size(20.dp))
                }
                item {
                    LazyRow {
                        item {
                            Column(
                                modifier = Modifier.padding(end = 0.dp, start = 0.dp)
                            ) {
                                ImageHomeComponent(
                                    id = R.drawable.chats,
                                    text = stringResource(R.string.CHATS),
                                    width = 150,
                                    height = 150,
                                    onClick = { /* Acción cuando se hace clic en el botón */ }
                                )
                                Spacer(modifier = Modifier.size(10.dp))
                                ImageHomeComponent(
                                    id = R.drawable.my_informs,
                                    text = stringResource(R.string.MY_INFORMS),
                                    width = 150,
                                    height = 150,
                                    onClick = { /* Acción cuando se hace clic en el botón */ }
                                )
                            }
                        }
                        item { Spacer(modifier = Modifier.size(40.dp)) }
                        item {
                            ImageHomeComponent(
                                id = R.drawable.my_clients,
                                text = stringResource(R.string.MY_CLIENTS),
                                width = 150,
                                height = 310,
                                onClick = { /* Acción cuando se hace clic en el botón */ }
                            )
                        }
                    }
                }
            }
            Text(
                modifier = Modifier.padding(20.dp, 5.dp),
                text = stringResource(R.string.AGENDA),
                color = colorResource(id = R.color.white),
                fontSize = 20.sp
            )

            LazyColumn {

                item {
                    Box(
                        modifier = Modifier
                            .width(400.dp)
                            .height(100.dp)
                            .padding(20.dp, 5.dp)
                            .clip(
                                shape = androidx.compose.foundation.shape.RoundedCornerShape(
                                    20.dp
                                )
                            )
                            .background(colorResource(id = R.color.orange))
                    ) {
                        Box(
                            modifier = Modifier.padding(15.dp, 5.dp)
                        ) {
                            Column {
                                Spacer(modifier = Modifier.size(5.dp))
                                Text("12:45")
                                Text("Entrenador de fuerza")
                                Text("Jose Iturralde")
                            }
                        }
                    }
                    Box(
                        modifier = Modifier
                            .width(400.dp)
                            .height(80.dp)
                            .padding(20.dp, 5.dp)
                            .clip(
                                shape = androidx.compose.foundation.shape.RoundedCornerShape(
                                    20.dp
                                )
                            )
                            .background(colorResource(id = R.color.orange))
                    ) {
                        Box(
                            modifier = Modifier.padding(15.dp, 5.dp)
                        ) {
                            Column {
                                Spacer(modifier = Modifier.size(5.dp))
                                Text("09:30")
                                Text("Dieta keto")
                                Text("Pedro Sanchez")
                            }
                        }
                    }
                }
            }
        }
    }
}



@Preview
@Composable
private fun HomePersonalScreen_Preview() {
    //HomeProfesionalScreen(homeProfesionalViewModel)
}
