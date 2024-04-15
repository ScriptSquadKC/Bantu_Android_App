package com.example.bantu.ui.Register

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bantu.R
import com.example.bantu.ui.Components.CustomTextFieldReg
import com.example.bantu.ui.Login.LoginViewActivity
import com.example.bantu.ui.theme.BantuTheme

@Composable
fun RegisterScreen() {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        Modifier.fillMaxSize(), Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Column(
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {

                Spacer(modifier = Modifier.size(50.dp))
                Text(
                    textAlign = TextAlign.Center,
                    text = "Register",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold

                )
                Text(
                    text = "Create your account",
                    fontSize = 12.sp,
                )

                Spacer(modifier = Modifier.size(30.dp))

                Box {
                    CustomTextFieldReg(
                        placeholder = "Username",
                        isPassword = false,
                        icon = Icons.Filled.Person,
                        value = username,
                        onValueChange = {
                            username = it
                        }
                    )
                }

                Spacer(modifier = Modifier.size(10.dp))

                Box {
                    CustomTextFieldReg(
                        placeholder = "Your email",
                        isPassword = false, // Cambiado a true
                        icon = Icons.Filled.Email,
                        value = email,
                        onValueChange = {
                            email = it
                        }
                    )
                }

                Spacer(modifier = Modifier.size(10.dp))

                Box {
                    CustomTextFieldReg(
                        placeholder = "Password",
                        isPassword = true, // Cambiado a true
                        icon = Icons.Filled.Lock,
                        value = password,
                        onValueChange = {
                            password = it
                        }
                    )
                }


                Column(
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.size(20.dp))

                    Button(
                        onClick = { /*TODO*/ },

                        modifier = Modifier.width(200.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.dark_pink)
                        )
                    ) {

                        Text(
                            text = "Sign in",
                            fontSize = 16.sp,
                        )

                    }

                    Spacer(modifier = Modifier.size(30.dp))

                    Text(
                        text = "------ Or continue with ------",
                        fontSize = 14.sp,
                    )
                    Spacer(modifier = Modifier.size(30.dp))
                    Row(
                        modifier = Modifier
                    ) {


                            IconButton(
                                onClick = { /* Maneja el evento de clic aquí */ }
                            ) {
                                Image(
                                    modifier = Modifier.size(50.dp,46.dp),
                                    painter = painterResource(id = R.drawable.facebook_icon3),
                                    contentDescription = "facebook_icon_conect",
                                    contentScale = ContentScale.Crop
                                )
                            }
                            Spacer(modifier = Modifier.size(30.dp))
                            IconButton(
                                onClick = { /* Maneja el evento de clic aquí */ }
                            ) {
                                Image(
                                    modifier = Modifier.size(36.dp,36.dp),
                                    painter = painterResource(id = R.drawable.google_icon),
                                    contentDescription = "google_icon_conect",
                                    contentScale = ContentScale.Crop
                                )
                            }



                    }
                }

            }

        }

    }
}




@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    val loginViewActivity = LoginViewActivity()
    BantuTheme {
        RegisterScreen()
    }
}
