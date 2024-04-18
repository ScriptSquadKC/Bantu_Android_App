package com.example.bantu.ui.Components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bantu.R
import com.example.bantu.ui.Login.LoginActivity
import com.example.bantu.ui.theme.BantuTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextFieldReg(
    placeholder: String,
    value: String,
    isPassword: Boolean,
    icon: ImageVector,
    onValueChange: (String) -> Unit,
    fontSize: Int
) {
    TextField(
        value = value,
        onValueChange = { onValueChange(it) },
        shape = RoundedCornerShape(30.dp),
        modifier = Modifier
            .border(
                width = 2.dp,
                color = colorResource(id = R.color.dark_pink),
                shape = CircleShape,
            ),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,

            ),
        label = {
            Text(
                text = placeholder,
                fontSize = fontSize.sp,
            )
        },
        leadingIcon = {
            if (isPassword) {
                Icon(imageVector = icon, contentDescription = "Custom icon")
            } else {
                Icon(imageVector = icon, contentDescription = "Custom icon")
            }
        },
        trailingIcon = {
            if (isPassword) Icon(
                imageVector = Icons.Filled.Info,
                contentDescription = "Custom icon"
            )
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = if (isPassword) KeyboardType.Password else KeyboardType.Text,
            capitalization = KeyboardCapitalization.None
        ),
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None
    )
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
        CustomTextFieldReg(
            placeholder = "NickName",
            isPassword = false,
            icon = Icons.Filled.Person,
            value = "nickname",
            onValueChange = {
            },
            fontSize = 14

        )
}