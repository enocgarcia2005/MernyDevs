package com.example.cooksy.screens.login.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.cooksy.components.DividerSpecial
import com.example.cooksy.components.PrimaryButton
import com.example.cooksy.components.SecondaryButton
import com.example.cooksy.components.TextFieldLogin
import com.example.cooksy.navigation.LoginScreens
import com.example.cooksy.screens.login.LoginScreenViewModel

@Composable
fun LoginSection(
    email:String,
    password:String,
    navHostController: NavHostController,
    enabled:Boolean,
    isEmailValid: Boolean,
    isPasswordValid: Boolean,
    hidden: Boolean,
    viewModel: LoginScreenViewModel) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
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
            placeHolder = "Email",
            icon = Icons.Filled.AccountCircle,
            value = email,
            isError = !isEmailValid,
            onClickHidden = {},
            errorMessage = "Email no valido",
            keyboardType = KeyboardType.Email
        ){
            viewModel.onLoginChanged(it, password)
            viewModel.isEnabled()
        }
        Spacer(modifier = Modifier.height(30.dp))
        TextFieldLogin(
            placeHolder = "Contraseña",
            icon = Icons.Filled.Lock,
            value = password,
            isError = !isPasswordValid,
            hidden = hidden,
            onClickHidden = {viewModel.hiddenPassword(hidden)},
            errorMessage = "minimo 8 caracteres",
            passwordMode = true,
            keyboardType = KeyboardType.Password
        ) {
            viewModel.onLoginChanged(email, it)
            viewModel.isEnabled()
        }
        Spacer(modifier = Modifier.height(36.dp))
        PrimaryButton(
            text = "Iniciar Sesión",
            enabled = enabled,
            modifier = Modifier.fillMaxWidth()
        ){
            viewModel.isEmail(email)
            viewModel.isPassword(password)
            if (isEmailValid&&isPasswordValid) {
                viewModel.logIn(email, password) {
                    navHostController.navigate(LoginScreens.Welcome.route)
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Has olvidado tu contraseña?",
            fontSize = 13.sp,
            textAlign = TextAlign.End,
            color = Color.White,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(25.dp))
        DividerSpecial(
            text = "No tienes cuenta?",
            color = Color(0xFF0D2D44)
        )
        Spacer(modifier = Modifier.height(15.dp))
        SecondaryButton(
            text = "Registrarse",
            modifier = Modifier.fillMaxWidth()
        ){
            navHostController.navigate(LoginScreens.Register.route)
        }
    }
}