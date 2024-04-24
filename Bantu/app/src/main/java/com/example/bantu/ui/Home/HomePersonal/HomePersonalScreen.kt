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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bantu.R
import com.example.bantu.ui.Components.BotomBar
import com.example.bantu.ui.Components.ImageHomeComponent
import com.example.bantu.ui.Components.Toolbar
import com.example.bantu.ui.Home.HomeViewModel


@Composable
fun HomePersonalScreen(
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
            Content(
                modifier = Modifier.padding(paddingValues)
            )
        },
        bottomBar = { BotomBar() }
    )
}

@Composable
fun Content(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .then(modifier)
            .background(colorResource(id = R.color.backgroud_light))

    ) {
        Column() {
            LazyColumn(
                modifier = Modifier.padding(20.dp, 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                item {
                    ImageHomeComponent(
                        id = R.drawable.my_tables,
                        text = stringResource(R.string.MY_TABLES_EXERCISES),
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
                                    id = R.drawable.my_shoppings,
                                    text = stringResource(R.string.MY_SHOPINGS),
                                    width = 150,
                                    height = 150,
                                    onClick = { /* Acción cuando se hace clic en el botón */ }
                                )
                            }
                        }
                        item { Spacer(modifier = Modifier.size(40.dp)) }
                        item {
                            ImageHomeComponent(
                                id = R.drawable.my_profesionals,
                                text = stringResource(R.string.MY_PROFESIONALS),
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
                text = "Agenda",
                color = colorResource(id = R.color.black),
                fontSize = 20.sp
            )


            LazyColumn {

                item {
                    Box(
                        modifier = Modifier
                            .width(400.dp)
                            .height(210.dp)
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
                                Text("Entrenador personal")
                                Text("Raul Gonzalez")
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
                                Text("Nutritionista personal")
                                Text("Mariano Rajoy")
                            }
                        }
                    }
                }
            }
        }
    }
}

