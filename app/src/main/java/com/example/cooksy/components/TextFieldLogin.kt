package com.example.cooksy.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.sp
import com.example.cooksy.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldLogin(
    placeHolder:String,
    icon:ImageVector,
    value:String,
    isError:Boolean,
    errorMessage:String,
    passwordMode:Boolean = false,
    hidden:Boolean = false,
    onClickHidden: () -> Unit ,
    keyboardType: KeyboardType,
    onValueChange: (String) -> Unit
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        leadingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = null
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        placeholder = {
            Text(
                text = placeHolder,
                color = Color.Gray
            )
        },
        visualTransformation =
        if (hidden) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
                       if(passwordMode) {
                           IconButton(onClick =  onClickHidden ) {
                               Icon(
                                   painter = painterResource(
                                       id =
                                       if (hidden) R.drawable.baseline_visibility_24
                                       else R.drawable.baseline_visibility_off_24
                                   ),
                                   contentDescription = null
                               )
                           }
                       }
        },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        isError = isError,
        modifier = Modifier.fillMaxWidth()
    )

    if (isError){
        Text(
            text = errorMessage,
            color = MaterialTheme.colorScheme.error,
            fontSize = 13.sp,
            modifier = Modifier.fillMaxWidth()
        )
    }
}