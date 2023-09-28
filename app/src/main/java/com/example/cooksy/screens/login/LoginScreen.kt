package com.example.cooksy.screens.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cooksy.components.BackButton
import com.example.cooksy.components.WelcomeLoginSection
import com.example.cooksy.screens.login.sections.LoginSection

@Composable
fun LoginScreen(modifier: Modifier = Modifier, navHostController: NavHostController,viewModel:LoginScreenViewModel) {
    val email: String by viewModel.email.observeAsState(initial = "")
    val password: String by viewModel.password.observeAsState(initial = "")

    Column( modifier =  modifier.fillMaxSize()) {
        WelcomeLoginSection(text = "Bienvenido \n de vuelta")
        Spacer(modifier = Modifier.height(30.dp))
        LoginSection(
            email = email,
            password = password,
            navHostController = navHostController,
            viewModel = viewModel
        )
    }
    BackButton {
        navHostController.popBackStack()
    }
}