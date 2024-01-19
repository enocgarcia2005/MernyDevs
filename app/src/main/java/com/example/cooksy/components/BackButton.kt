package com.example.cooksy.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable

@Composable
fun BackButton(onClick:() -> Unit) {
    Box{
        IconButton(onClick = onClick ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Regresar")
        }
    }
}