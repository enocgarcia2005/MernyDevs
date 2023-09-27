package com.example.cooksy.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun DividerSpecial(text: String, color: Color) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Divider(
            color = color,
            modifier = Modifier.width(87.dp)
        )
        Text(text = text,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center,
            color = color
        )
        Divider(
            color = color,
            modifier = Modifier.width(87.dp)
        )
    }
}