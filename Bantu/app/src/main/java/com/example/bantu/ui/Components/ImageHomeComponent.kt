package com.example.bantu.ui.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bantu.R

@Composable
fun ImageHomeComponent(
    id: Int,
    text: String,
    width: Int,
    height: Int,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .width(width.dp)
            .height(height.dp)
            .clickable(onClick = onClick), // Hacer que la caja sea cliclable
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = id),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Text(
            text = text,
            color = colorResource(id = R.color.orange),
            fontSize = 15.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 20.dp)
                .background(
                    color = Color.Black.copy(alpha = 0.5f),

                    ),

        )
    }
}

@Preview()
@Composable
fun PreviewImageHomeComponent() {
    ImageHomeComponent(
        id = R.drawable.logo,
        text = "Your Text Here",
        width = 200, //
        height = 200, //
        onClick = {}


    )
}