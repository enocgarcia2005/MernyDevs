package com.example.cooksy.screens.welcome.sections

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cooksy.components.PrimaryButton
import com.example.cooksy.components.SecondaryButton
import com.example.cooksy.navigation.LoginScreens

@Composable
fun SectionButtons(navHostController: NavHostController) {
    Row (
        modifier = Modifier.fillMaxWidth()
    ){
        PrimaryButton(text = "Iniciar Sesión", modifier = Modifier.weight(1f)){
            navHostController.navigate(LoginScreens.Login.route)
        }
        Spacer(modifier = Modifier.width(36.dp))
        SecondaryButton(text = "Registrarse", modifier = Modifier.weight(1f)){
            navHostController.navigate(LoginScreens.Register.route)
        }

    }
}