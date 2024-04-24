package com.example.bantu.ui.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.bantu.R
import com.example.bantu.ui.Home.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar(
    homeViewModel: HomeViewModel,
    name: String?,
    photo: String?
) {
    val nameUser: String = name ?: "Usuario"
    //val photoUser = photo ?: "https://image.pngaaa.com/553/2189553-middle.png"
    val photoUser = photo ?: "http://90.163.132.130:8090/bantu/user03.png"
    //val photoUser = "https://image.pngaaa.com/553/2189553-middle.png"
    //Log.w("PHOTO", photoUser)

    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(id = R.color.orange),
        ),
        title = {
            Row (
                modifier = Modifier
                    .padding(horizontal = 8.dp), // Espacio horizontal entre los elementos
                verticalAlignment = Alignment.CenterVertically
            ){

                Box(
                    modifier = Modifier.width(300.dp),
                ) {
                    LazyRow(
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        item {

                            Image(
                                painter = rememberAsyncImagePainter(
                                    ImageRequest.Builder(LocalContext.current)
                                        .data(data = photoUser)
                                        .apply(block = fun ImageRequest.Builder.() {
                                            crossfade(true)
                                            placeholder(R.drawable.icon_user)
                                        }).build()
                                ),
                                contentDescription = "photouser",
                                modifier = Modifier
                                    .background(Color.Black)
                                    .size(40.dp, 40.dp)
                                    .fillMaxWidth(),

                                contentScale = ContentScale.Fit,
                            )
                        }
                        item {
                            Spacer(modifier = Modifier.size(20.dp))
                        }
                        item {
                            Text(
                                text = "${stringResource(R.string.HELLO)},",
                                color = colorResource(id = R.color.black)
                            )
                        }
                        item {
                            Spacer(modifier = Modifier.size(20.dp))
                        }
                        item {
                            Text(
                                text = nameUser,
                                color = colorResource(id = R.color.black)
                            )
                        }

                        item {
                            Row(
                                modifier = Modifier.padding(0.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Spacer(modifier = Modifier.size(10.dp))

                            }
                        }
                    }
                }

                Box(
                    modifier = Modifier.size(1000.dp,50.dp)
                ) {
                    Button(
                        onClick = {
                            homeViewModel.clearPreferences()
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.orange)
                        )
                    ) {
                        Icon(
                            tint = Color.Black,
                            imageVector = Icons.Default.ExitToApp,
                            contentDescription = "Logout"
                        )
                    }
                }
            }
        },
        modifier = Modifier.fillMaxWidth()
    )
}