package com.example.bantu.ui.Login.RegisterView

import android.provider.ContactsContract.Contacts.Photo
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.getString
import com.example.bantu.R
import com.example.bantu.ui.Components.CustomTextFieldReg
import com.example.bantu.ui.Components.DropdownMenu
import com.example.bantu.ui.Login.LoginActivity
import com.example.bantu.ui.theme.BantuTheme

@Composable
fun RegisterViewScreen(
    registerViewModel: RegisterViewModel
) {
    var nickname by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var profesional by remember { mutableStateOf("") }


    val fontSizeTexfield = 14

    Box(
        Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Spacer(modifier = Modifier.size(80.dp))
            Image(
                modifier = Modifier.size(150.dp, 150.dp),
                painter = painterResource(id = R.drawable.logo2),
                contentDescription = "logoapp",
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.size(20.dp))
            Text(
                textAlign = TextAlign.Center,
                text =stringResource(R.string.REGISTER),
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold

            )
            Text(
                text = stringResource(R.string.CREATE_YOUR_ACCOUNT),
                fontSize = 12.sp,
            )

            Spacer(modifier = Modifier.size(20.dp))

            Box(
                modifier = Modifier.size(300.dp)
            ) {
                LazyColumn(
                    modifier =
                    Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp),

                    ) {


                    item {
                        Box(
                        ) {
                            CustomTextFieldReg(
                                placeholder = R.string.NICKNAME,
                                isPassword = false,
                                icon = Icons.Filled.Person,
                                value = nickname,
                                onValueChange = {
                                    nickname = it
                                },
                                fontSize = fontSizeTexfield
                            )
                        }
                    }
                    item {

                        CustomTextFieldReg(
                            placeholder =R.string.YOUR_EMAIL,
                            isPassword = false, // Cambiado a true
                            icon = Icons.Filled.Email,
                            value = email,
                            onValueChange = {
                                email = it
                            },
                            fontSize = fontSizeTexfield
                        )

                    }
                    item {
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
                    }

                    item {
                        Box {
                            CustomTextFieldReg(
                                placeholder = R.string.PROFESIONAL,
                                isPassword = false,
                                icon = Icons.Filled.Person,
                                value = profesional,
                                onValueChange = {
                                    profesional = it
                                },
                                fontSize = fontSizeTexfield
                            )
                        }
                    }
                }
            }
                Spacer(modifier = Modifier.size(10.dp))

                Button(
                    onClick = {
                        registerViewModel.launchRegister(
                            nickname,
                            email,
                            password,
                            profesional,
                        )
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

                Spacer(modifier = Modifier.size(30.dp))


        }
    }
}




/*
@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    val loginViewActivity = LoginActivity()
    BantuTheme {
        RegisterViewScreen()
    }
}


 */