package com.example.cooksy.screens.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cooksy.components.BackButton
import com.example.cooksy.components.WelcomeLoginSection
import com.example.cooksy.screens.register.sections.RegisterSection

@Composable
fun RegisterScreen(modifier: Modifier = Modifier, navHostController: NavHostController) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        WelcomeLoginSection(text = "Bienvenido \n a Cooksy")
        Spacer(modifier = Modifier.height(10.dp))
        RegisterSection()
    }
    BackButton {
        navHostController.popBackStack()
    }
}
