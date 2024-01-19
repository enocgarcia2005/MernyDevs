package com.example.cooksy.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cooksy.R

@Composable
fun GoogleButton() {
    OutlinedButton(
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        onClick = { },
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
        ){
            Image(
                painter = painterResource(id = R.drawable.logo_google) ,
                contentDescription = "logo google",
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color(0xFF0D2D44))
                    .padding(4.dp)
            )
            Text(
                text = "Iniciar con Google",
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                color = Color(0xFF0D2D44),
                modifier = Modifier.fillMaxWidth()
            )
        }

    }
}