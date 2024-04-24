package com.example.bantu.ui.Login.LoginView

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bantu.R
import com.example.bantu.ui.Components.CustomTextFieldReg
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun LoginViewScreen(
    loginViewModel: LoginViewModel,
    navController: NavController
) {
    /*
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

     */
    var username = "jpadrells@bantu.com"
    var password = "password"



    var emailError by remember { mutableStateOf(false) }
    var passwordError by remember { mutableStateOf(false) }
    val checkedState = remember { mutableStateOf(true) }
    val fontSizeTexfield = 14

    Box(
        Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.backgroud_light)), Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Image(
                modifier = Modifier.size(150.dp, 150.dp),
                painter = painterResource(id = R.drawable.logo2),
                contentDescription = "logoapp",
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.size(20.dp))
            Text(
                textAlign = TextAlign.Center,
                text = stringResource(id = R.string.WELLCOME_BACK),
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.white)

            )
            Text(
                text = stringResource(R.string.LOGIN_TO_YOUR_ACCOUNT),
                fontSize = 12.sp,
                color = colorResource(id = R.color.white)
            )

            Spacer(modifier = Modifier.size(20.dp))

            Box(
                modifier = Modifier
            ) {
                CustomTextFieldReg(
                    placeholder = R.string.EMAIL,
                    isPassword = false,
                    icon = Icons.Filled.Email,
                    value = username,
                    onValueChange = {
                        username = it
                    },
                    fontSize = fontSizeTexfield
                )
            }

            if (emailError) {
                Text(
                    text = "¡¡Email error!!",
                    fontSize = 12.sp,
                    color = Color.Red,
                )
            }
            Spacer(modifier = Modifier.size(20.dp))

            Box {
                CustomTextFieldReg(
                    placeholder = R.string.PASSWORD,
                    isPassword = true, // Cambiado a true
                    icon = Icons.Filled.Lock,
                    value = password,
                    onValueChange = {
                        password = it
                    },
                    fontSize = fontSizeTexfield
                )
            }
            if (passwordError) {
                Text(
                    text = "¡¡Password error!!",
                    fontSize = 12.sp,
                    color = Color.Red
                )
            }

            Spacer(modifier = Modifier.size(15.dp))

            Box (
                modifier = Modifier.size(250.dp, 30.dp)

            ){
                Row(
                    modifier = Modifier
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.size(100.dp, 30.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Checkbox(
                                modifier = Modifier
                                    .size(5.dp),
                                checked = checkedState.value,
                                onCheckedChange = { checkedState.value = it },
                                colors = CheckboxDefaults.colors(
                                    checkedColor = colorResource(id = R.color.orange),

                                    uncheckedColor = Color.Gray,
                                    checkmarkColor = Color.White
                                ),
                            )
                            Spacer(modifier = Modifier.size(10.dp))
                            Text(
                                text = stringResource(R.string.REMERBERME),
                                fontSize = 10.sp,
                                color = colorResource(id = R.color.white)
                            )
                        }
                    }

                    Box() {
                        Spacer(modifier = Modifier.size(50.dp))
                    }
                    Box {
                        TextButton(onClick = { /* Do something! */ }) {
                            Text(
                                text = stringResource(R.string.FORGOT_PASSWORD),
                                fontSize = 10.sp,
                                color = colorResource(id = R.color.orange)
                            )
                        }
                    }
                }
            }


            Column(
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.size(25.dp))
                Button(
                    onClick = {

                        if (username.contains("@") && password.length >= 4) {
                            loginViewModel.launchLogin(username, password)
                        } else {
                            emailError = !username.contains("@")
                            passwordError = password.length < 4
                        }
                    },

                    modifier = Modifier.width(200.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.orange)
                    )
                ) {
                    Text(
                        text = stringResource(R.string.SIGN_IN),
                        fontSize = 16.sp,
                    )

                }

                Spacer(modifier = Modifier.size(50.dp))

                Button(
                    onClick = {
                        // IR AL REGISTER_SCREEN
                        navController.navigate("RegisterRoute")

                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.dark_pink)
                    )
                ) {
                    Text(
                        text = stringResource(R.string.CREATE_YOUR_ACCOUNT),
                        fontSize = 10.sp,
                    )

                }
            }

        }

    }
}
