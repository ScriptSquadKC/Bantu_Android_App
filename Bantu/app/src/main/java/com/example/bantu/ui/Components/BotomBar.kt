package com.example.bantu.ui.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.SupervisedUserCircle
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.bantu.R

@Composable
fun BotomBar(

) {
    BottomAppBar(
        modifier = Modifier
            .background(color = colorResource(id = R.color.botomBar)),

    ) {
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
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
                ) {
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
                ) {
                    Icon(
                        tint = Color.Black,
                        imageVector = Icons.Default.SupervisedUserCircle,
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
                ) {
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
private fun BotomBar_Preview() {
    BotomBar()
}