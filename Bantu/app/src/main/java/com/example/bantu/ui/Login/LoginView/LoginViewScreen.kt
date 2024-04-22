package com.example.bantu.ui.Login.LoginView

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bantu.R
import com.example.bantu.ui.Components.CustomTextFieldReg
import com.example.bantu.ui.Login.LoginActivity
import com.example.bantu.ui.theme.BantuTheme

@Composable
fun LoginViewScreen(loginViewModel: LoginViewModel, navController: NavController) {
    //var username by remember { mutableStateOf("") }
    //var password by remember { mutableStateOf("") }
    var username = "test@email.es"
    var password = "password"

    var emailError : Boolean = false
    var passwordError : Boolean = false
    val heightTextfield = 40
    val fontSizeTexfield = 14

    Box(
        Modifier.fillMaxSize(), Alignment.Center
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

                Box( modifier = Modifier
                ){
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

                if(emailError) {
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
                if(passwordError) {
                    Text(
                        text = "¡¡Password error!!",
                        fontSize = 12.sp,
                        color = Color.Red
                    )
                }
                LazyRow(
                    modifier = Modifier
                ) {
                    item() {


                        TextButton(onClick = { /* Do something! */ }) {
                            Row() {
                                Icon(
                                    imageVector = Icons.Filled.CheckCircle,
                                    contentDescription = stringResource(R.string.REMERBERME),
                                    modifier = Modifier.size(14.dp),
                                    tint = colorResource(id = R.color.orange)
                                )
                                Text(
                                    text = stringResource(R.string.REMERBERME),
                                    fontSize = 10.sp,
                                    color = colorResource(id = R.color.white)
                                )
                            }
                        }
                    }

                    item() {
                        Spacer(modifier = Modifier.size(50.dp))
                    }

                    item() {
                        TextButton(onClick = { /* Do something! */ }) {
                            Text(
                                text = stringResource(R.string.FORGOT_PASSWORD),
                                fontSize = 10.sp,
                                color = colorResource(id = R.color.orange)
                            )

                        }
                    }

                }
                Column(
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(
                        onClick = { loginViewModel.launchLogin(username, password) },

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

                    Spacer(modifier = Modifier.size(30.dp))

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


@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    val loginActivity = LoginActivity()
    BantuTheme {
        //LoginViewScreen()
    }
}
