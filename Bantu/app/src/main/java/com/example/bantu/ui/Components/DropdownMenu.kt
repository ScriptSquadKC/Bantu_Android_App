package com.example.bantu.ui.Components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bantu.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownMenu (
    fontSize: Int

){


    var isExpanded by remember {
        mutableStateOf(false)
    }

    var gender by remember {
        mutableStateOf("")
    }
    Box() {
        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = { isExpanded = (it) }
        ) {

            TextField(
                value = gender,
                shape = RoundedCornerShape(30.dp),
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                },
                placeholder = {
                    Row(){
                        Icon(
                            imageVector = Icons.Filled.Person,
                            contentDescription = "Profesional")
                        Spacer(modifier = Modifier.size(10.dp))
                        Text(
                            text ="Profesional",
                            fontSize = fontSize.sp,
                            )
                    }


                              },
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,

                    ),
                modifier = Modifier
                    .menuAnchor()
                    .border(
                        width = 2.dp,
                        color = colorResource(id = R.color.dark_pink),
                        shape = CircleShape,
                    )
            )
            ExposedDropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false }
            ) {
                DropdownMenuItem(
                    text = {
                        Text("Personal")
                    },
                    onClick = {
                        gender = "Personal"
                        isExpanded = false
                    }
                )

                DropdownMenuItem(
                    text = {
                        Text("Profesional")
                    },
                    onClick = {
                        gender = "Profesional"
                        isExpanded = false
                    }
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DropdownMenuPreview() {

    DropdownMenu(30)
}
