package com.example.cooksy.screens.register

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
import com.example.cooksy.screens.login.LoginScreenViewModel
import com.example.cooksy.screens.register.sections.RegisterSection

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    viewModel:LoginScreenViewModel
    ) {
    val email: String by viewModel.email.observeAsState(initial = "")
    val password: String by viewModel.password.observeAsState(initial = "")
    val confirmPassword: String by viewModel.confirmPassword.observeAsState(initial = "")
    val isError: Boolean by viewModel.error.observeAsState(initial = false)
    val isEmailValid: Boolean by viewModel.emailValid.observeAsState(initial = true)
    val isPasswordValid: Boolean by viewModel.passwordValid.observeAsState(initial = true)
    val isEnabled: Boolean by viewModel.enabled.observeAsState(initial = false)
    val isActive: Boolean by viewModel.active.observeAsState(initial = false)
    val hidden: Boolean by viewModel.hidden.observeAsState(initial = true)

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        WelcomeLoginSection(text = "Bienvenido \n a Cooksy")
        Spacer(modifier = Modifier.height(10.dp))
        RegisterSection(
            email = email,
            password = password,
            confirmPassword = confirmPassword,
            navHostController = navHostController,
            isError = isError,
            isEmailValid= isEmailValid,
            isPasswordValid = isPasswordValid,
            enabled = isEnabled,
            active = isActive,
            hidden = hidden,
            viewModel = viewModel
        )
    }
    BackButton {
        navHostController.popBackStack()
    }
}
