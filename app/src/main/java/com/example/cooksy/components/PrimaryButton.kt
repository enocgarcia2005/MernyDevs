package com.example.cooksy.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun PrimaryButton(modifier: Modifier = Modifier, text:String) {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF0D2D44)
        ),
        onClick = { },
        modifier = modifier
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,

            )
    }
}