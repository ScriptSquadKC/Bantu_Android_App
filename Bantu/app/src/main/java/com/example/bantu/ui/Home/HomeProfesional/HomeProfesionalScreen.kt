package com.example.bantu.ui.Home.HomeProfesional

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bantu.R
import com.example.bantu.ui.Components.ImageHomeComponent


@Composable
fun HomeProfesionalScreen() {

    var nameUser: String = "Inma"


    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column (

        ){
            Box(
                modifier = Modifier
                    .background(colorResource(id = R.color.orange))
                    .fillMaxWidth()
                    .height(70.dp),
                contentAlignment = Alignment.CenterStart

            ) {
                Row(
                    modifier = Modifier.padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically


                ) {

                    Image(
                        modifier = Modifier.size(40.dp, 40.dp),
                        painter = painterResource(id = R.drawable.icon_user),
                        contentDescription = "icon user"
                    )
                    Spacer(modifier = Modifier.size(10.dp))
                    Text(
                        text = "Hola,",
                        color = colorResource(id = R.color.black)

                    )
                    Spacer(modifier = Modifier.size(10.dp))
                    Text(
                        text = nameUser,
                        color = colorResource(id = R.color.black)
                    )
                }
            }

            LazyColumn (
                modifier = Modifier.padding(10.dp,0.dp),
                //verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                item {
                    ImageHomeComponent(
                        id = R.drawable.rectangle_1,
                        text = "Crear rutinas",
                        width = 400,
                        height = 150,
                        onClick = { /* Acción cuando se hace clic en el botón */ }
                    )
                }

                item {
                    LazyRow {
                        item {
                            Column (
                                modifier = Modifier.padding(end = 10.dp)
                            ){
                                ImageHomeComponent(
                                    id = R.drawable.rectangle_2,
                                    text = "Chats",
                                    width = 180,
                                    height = 180,
                                    onClick = { /* Acción cuando se hace clic en el botón */ }

                                )

                                ImageHomeComponent(
                                    id = R.drawable.rectangle_3,
                                    text = "Mis informes",
                                    width = 180,
                                    height = 180,
                                    onClick = { /* Acción cuando se hace clic en el botón */ }
                                )
                            }
                        }

                        item {
                            ImageHomeComponent(
                                id = R.drawable.rectangle_4,
                                text = "Mis clientes",
                                width = 180,
                                height = 360,
                                onClick = { /* Acción cuando se hace clic en el botón */ }
                            )
                        }
                    }


                }


            }


            LazyColumn {
                item {
                    Text(
                        modifier = Modifier.padding(20.dp, 5.dp),
                        text = "Agenda",
                        color = colorResource(id = R.color.white),
                        fontSize = 20.sp
                    )
                }

                item {
                    Box(
                        modifier = Modifier
                            .width(400.dp)
                            .height(100.dp)
                            .padding(20.dp, 5.dp)
                            .clip(shape = androidx.compose.foundation.shape.RoundedCornerShape(20.dp))
                            .background(colorResource(id = R.color.orange))
                    ) {
                        Box(
                            modifier = Modifier.padding(15.dp, 5.dp)
                        ) {
                            Column {
                                Spacer(modifier = Modifier.size(5.dp))
                                Text("12:45 - 13:15")
                                Text("Sesion de entrenamiento")
                                Text("Raul Maroto")
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
private fun HomeProfesionalScreen_Preview() {
    HomeProfesionalScreen()
}
