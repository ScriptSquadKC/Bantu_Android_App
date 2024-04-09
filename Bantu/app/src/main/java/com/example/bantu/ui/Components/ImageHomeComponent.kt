package com.example.bantu.ui.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bantu.MainActivity
import com.example.bantu.R
import com.example.bantu.ui.Login.LoginScreen
import com.example.bantu.ui.theme.BantuTheme

@Composable
fun ImageHomeComponent(
    id: Int,
    text: String,
    width: Int,
    height: Int
){
    Box(
        modifier = Modifier
            .width(width.dp)
            .height(height.dp)
            .padding(10.dp)
            .clip(shape = androidx.compose.foundation.shape.RoundedCornerShape(20.dp))
    ) {
        Image(
            painter = painterResource(id = id),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        ) {
            Text(
                text = text,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Preview()
@Composable
fun PreviewImageHomeComponent() {
    ImageHomeComponent(
        id = R.drawable.logo,
        text = "Your Text Here",
        width = 200, // Ancho de la imagen
        height = 200 // Altura de la imagen
    )
}