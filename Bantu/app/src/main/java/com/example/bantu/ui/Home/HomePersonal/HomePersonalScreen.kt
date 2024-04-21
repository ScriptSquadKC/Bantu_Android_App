package com.example.bantu.ui.Home.HomePersonal

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bantu.R
import com.example.bantu.ui.Components.ImageHomeComponent


@Composable
fun HomePersonalScreen() {

    Scaffold (
        topBar = {Toolbar()},
        content = { paddingValues ->
            Content(
                modifier = Modifier.padding(paddingValues)
        ) },
        bottomBar = { BotomBar() }
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar(){
    var nameUser: String = "Inma"
    TopAppBar(
        title = {
            Box(
                modifier = Modifier
                    .background(colorResource(id = R.color.orange))
                    .fillMaxWidth() // Aquí se aplica fillMaxWidth() directamente a la TopAppBar
                    .height(70.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Row(
                    modifier = Modifier.padding(0.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier.size(40.dp, 40.dp),
                        painter = painterResource(id = R.drawable.icon_user),
                        contentDescription = "icon user"
                    )
                    Spacer(modifier = Modifier.size(10.dp))
                    Text(
                        text = "${stringResource(R.string.HELLO)},",
                        color = colorResource(id = R.color.black)
                    )
                    Spacer(modifier = Modifier.size(20.dp))
                    Text(
                        text = nameUser,
                        color = colorResource(id = R.color.black)
                    )
                }
            }
        },
        modifier = Modifier.fillMaxWidth()
    )
}


@Composable
fun Content(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .then(modifier)

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
                }
            }
        }
    }
}

@Composable
fun BotomBar(

) {
    BottomAppBar() {
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Icon(
                        tint = Color.Black,
                        imageVector = Icons.Default.Home,
                        contentDescription = "Home"
                    )
                    Text(
                        text = "Home",
                        color = Color.Black
                    )
                }
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Icon(
                        tint = Color.Black,
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search"
                    )
                    Text(
                        text = "Search",
                        color = Color.Black
                    )
                }
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Icon(
                        tint = Color.Black,
                        imageVector = Icons.Default.Face,
                        contentDescription = "Social"
                    )
                    Text(
                        text = "Social",
                        color = Color.Black
                    )
                }
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Icon(
                        tint = Color.Black,
                        imageVector = Icons.Default.Settings,
                        contentDescription = "Settings"
                    )
                    Text(
                        text = "Settings",
                        color = Color.Black
                    )


                }
            }
        )
    }
}


@Preview
@Composable
private fun HomePersonalScreen_Preview() {
    HomePersonalScreen()
}
