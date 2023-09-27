package com.example.cooksy.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cooksy.R
import com.example.cooksy.components.DividerSpecial
import com.example.cooksy.components.PrimaryButton
import com.example.cooksy.components.SecondaryButton
import com.example.cooksy.components.TextFieldLogin
import com.example.cooksy.data.SliderItemList
import com.example.cooksy.ui.theme.CooksyTheme

@Composable
fun LoginScreen() {
    Column( modifier =  Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.imagotipo_alternative),
                contentDescription = stringResource(id = R.string.logo)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.admiracion_signo),
                    contentDescription = stringResource(id = R.string.logo)
                )
                Text(
                    text = "Bienvenido \n de vuelta",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
                Image(
                    painter = painterResource(id = R.drawable.admiracion_signo_cerrar),
                    contentDescription = stringResource(id = R.string.logo)
                )
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(20.dp))
                .background(Color(0xFFF49957))
                .padding(20.dp)
        ) {
            Text(
                text = "Inicio de sesión",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(40.dp))
            TextFieldLogin(
                placeHolder = "Usuario" ,
                icon = Icons.Filled.AccountCircle
            )
            Spacer(modifier = Modifier.height(30.dp))
            TextFieldLogin(
                placeHolder = "Contraseña" ,
                icon = Icons.Filled.Lock
            )
            Spacer(modifier = Modifier.height(36.dp))
            PrimaryButton(
                text = "Iniciar Sesión",
                modifier = Modifier.fillMaxWidth()
                )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text ="Has olvidado tu contraseña?" ,
                fontSize = 13.sp,
                textAlign = TextAlign.End,
                color = Color.White,
                modifier = Modifier.fillMaxWidth()
                )
            Spacer(modifier = Modifier.height(25.dp))
            DividerSpecial(
                text = "No tienes cuenta?",
                color =  Color(0xFF0D2D44)
            )
            Spacer(modifier = Modifier.height(15.dp))
            SecondaryButton(
                text = "Registrarse",
              modifier =  Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    CooksyTheme {
        LoginScreen()
    }
}