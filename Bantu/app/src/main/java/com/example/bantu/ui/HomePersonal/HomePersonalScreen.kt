package com.example.bantu.ui.HomePersonal

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
fun HomePersonalScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            Box(
                modifier = Modifier
                    .background(colorResource(id = R.color.orange))
                    .fillMaxWidth()
                    .height(100.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Row() {
                    Spacer(modifier = Modifier.size(10.dp))
                    Image(
                        modifier = Modifier.size(50.dp, 50.dp),
                        painter = painterResource(id = R.drawable.icon_user),
                        contentDescription = "icon user"
                    )
                    Spacer(modifier = Modifier.size(10.dp))
                    Text(
                        text = "Holaa,",
                        color = colorResource(id = R.color.black)
                    )
                    Spacer(modifier = Modifier.size(10.dp))
                    Text(
                        text = "Inma,",
                        color = colorResource(id = R.color.black)
                    )
                }
            }

            LazyColumn {
                item {
                    ImageHomeComponent(
                        id = R.drawable.rectangle_1,
                        text = "Mis Tablas de ejercicios",
                        width = 400,
                        height = 180
                    )
                }

                item {
                    LazyRow {
                        item {
                            Column {
                                ImageHomeComponent(
                                    id = R.drawable.rectangle_2,
                                    text = "Chats",
                                    width = 180,
                                    height = 180
                                )

                                    ImageHomeComponent(
                                        id = R.drawable.rectangle_3,
                                        text = "Mis compras",
                                        width = 180,
                                        height = 180
                                    )
                            }
                        }

                        item {
                            ImageHomeComponent(
                                id = R.drawable.rectangle_4,
                                text = "Mis compras",
                                width = 180,
                                height = 400
                            )
                        }
                    }


                }


            }

            LazyColumn(){
                item {
                    Box(
                        modifier = Modifier
                            .width(400.dp)
                            .height(100.dp)
                            .padding(20.dp, 0.dp)
                            .clip(shape = androidx.compose.foundation.shape.RoundedCornerShape(20.dp))
                            .background(colorResource(id = R.color.orange))
                    ) {
                        LazyColumn {
                            item {
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
    HomePersonalScreen()
}
