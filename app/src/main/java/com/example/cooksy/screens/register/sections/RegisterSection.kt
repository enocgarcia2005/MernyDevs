package com.example.cooksy.screens.register.sections

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
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
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
fun RegisterSection(
    email:String,
    password:String,
    confirmPassword:String,
    navHostController: NavHostController,
    isError: Boolean,
    isEmailValid: Boolean,
    isPasswordValid: Boolean,
    enabled:Boolean,
    active:Boolean,
    hidden:Boolean,
    viewModel: LoginScreenViewModel
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
            .background(Color(0xFFF49957))
            .padding(20.dp)
    ) {
        Text(
            text = "Registrate",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(30.dp))
        TextFieldLogin(
            placeHolder = "Correo",
            icon = Icons.Filled.AccountCircle,
            value = email,
            isError = !isEmailValid,
            onClickHidden = {},
            keyboardType = KeyboardType.Email,
            errorMessage = "Email no valido"){
            viewModel.onLoginChanged(it, password)
            viewModel.confirmPasswordEmpty()
        }
        Spacer(modifier = Modifier.height(20.dp))
        TextFieldLogin(
            placeHolder = "Contraseña",
            icon = Icons.Filled.Lock,
            value = password,
            isError = isError || !isPasswordValid,
            onClickHidden = {viewModel.hiddenPassword(hidden)},
            hidden = hidden ,
            keyboardType = KeyboardType.Password,
            passwordMode = true,
            errorMessage = if(!isPasswordValid)"Minimo 8 caracteres" else "La contraseña no coincide"
        ){
            viewModel.onLoginChanged(email, it)
            viewModel.confirmPasswordEmpty()
        }
        Spacer(modifier = Modifier.height(20.dp))
        TextFieldLogin(
            placeHolder = "Confirmar Contraseña",
            icon = Icons.Filled.Lock,
            value = confirmPassword,
            isError = isError || !isPasswordValid,
            onClickHidden = {viewModel.hiddenPassword(hidden)},
            hidden = hidden,
            keyboardType = KeyboardType.Password,
            passwordMode = true,
            errorMessage = if(!isPasswordValid)"Minimo 8 caracteres" else "La contraseña no coincide"){
            viewModel.onConfirmPasswordChange(it)
            viewModel.confirmPasswordEmpty()
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            RadioButton(
                selected = active,
                onClick = {viewModel.activeRadioButton(active) },
                colors = RadioButtonDefaults.colors(
                    unselectedColor = Color.White,
                    selectedColor = Color.White
                ),
                )
            Text(
                text = "Acepto los terminos y condiciones de uso",
                textAlign = TextAlign.Center,
                fontSize = 13.sp,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        PrimaryButton(
            text = "Registrarse",
            enabled = enabled && active,
            modifier = Modifier.fillMaxWidth()
        ){
                viewModel.isEmail(email)
                viewModel.isPassword(password)
            if(isEmailValid && isPasswordValid) {
                if (password == confirmPassword) {
                    viewModel.isNotError()
                    viewModel.register(email, password) {
                        navHostController.navigate(LoginScreens.Welcome.route)
                    }
                } else {
                    viewModel.isError()
                }
            }
            }
        Spacer(modifier = Modifier.height(10.dp))
        DividerSpecial(
            text = "ya tienes cuenta?",
            color = Color(0xFF0D2D44)
        )
        Spacer(modifier = Modifier.height(10.dp))
        SecondaryButton(
            text = "Iniciar Sesión",
            modifier = Modifier.fillMaxWidth()
        ){
            navHostController.navigate(LoginScreens.Login.route)
        }
    }
}
