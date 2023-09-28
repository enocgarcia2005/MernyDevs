package com.example.cooksy.screens.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cooksy.components.WelcomeLoginSection
import com.example.cooksy.screens.login.sections.LoginSection
import com.example.cooksy.ui.theme.CooksyTheme

@Composable
fun LoginScreen() {
    Column( modifier =  Modifier.fillMaxSize()) {
        WelcomeLoginSection(text = "Bienvenido \n de vuelta")
        Spacer(modifier = Modifier.height(30.dp))
        LoginSection()
    }
}



@Preview(showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    CooksyTheme {
        LoginScreen()
    }
}