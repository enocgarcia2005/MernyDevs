package com.example.cooksy.screens.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cooksy.components.WelcomeLoginSection
import com.example.cooksy.screens.register.sections.RegisterSection
import com.example.cooksy.ui.theme.CooksyTheme

@Composable
fun RegisterScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        WelcomeLoginSection(text = "Bienvenido \n a Cooksy")
        Spacer(modifier = Modifier.height(10.dp))
        RegisterSection()
    }
}

@Preview(showSystemUi = true)
@Composable
fun RegisterScreenPreview() {
    CooksyTheme {
        RegisterScreen()
    }
}