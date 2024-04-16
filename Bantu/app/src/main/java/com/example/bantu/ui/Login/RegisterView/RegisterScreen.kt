package com.example.bantu.ui.Login.RegisterView

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bantu.R
import com.example.bantu.ui.Components.CustomTextFieldReg
import com.example.bantu.ui.Login.LoginActivity
import com.example.bantu.ui.theme.BantuTheme

@Composable
fun RegisterScreen() {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var choose_option by remember { mutableStateOf("") }
    var country by remember { mutableStateOf("") }
    var province by remember { mutableStateOf("") }

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
                Image(
                    modifier = Modifier.size(150.dp,150.dp),
                    painter = painterResource(id = R.drawable.logo2),
                    contentDescription = "logoapp",
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.size(10.dp))
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
                Spacer(modifier = Modifier.size(10.dp))
                Box {
                    CustomTextFieldReg(
                        placeholder = "Choose an option",
                        isPassword = false,
                        icon = Icons.Filled.Person,
                        value = choose_option,
                        onValueChange = {
                            choose_option = it
                        }
                    )
                }

                Spacer(modifier = Modifier.size(10.dp))

                Box {
                    CustomTextFieldReg(
                        placeholder = "Your Country",
                        isPassword = false,
                        icon = Icons.Filled.Person,
                        value = country,
                        onValueChange = {
                            country = it
                        }
                    )
                }

                Spacer(modifier = Modifier.size(10.dp))

                Box {
                    CustomTextFieldReg(
                        placeholder = "Your province",
                        isPassword = false,
                        icon = Icons.Filled.Person,
                        value = province,
                        onValueChange = {
                            province = it
                        }
                    )
                }

                Spacer(modifier = Modifier.size(10.dp))


                Column(
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.size(20.dp))

                    Button(
                        onClick = { /*TODO*/ },

                        modifier = Modifier.width(200.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.orange)
                        )
                    ) {

                        Text(
                            text = "Sign in",
                            fontSize = 16.sp,
                        )

                    }

                    Spacer(modifier = Modifier.size(30.dp))



                    }
                }

            }

        }
}




@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    val loginViewActivity = LoginActivity()
    BantuTheme {
        RegisterScreen()
    }
}
