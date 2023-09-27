package com.example.cooksy.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun DividerSpecial() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Divider(modifier = Modifier.width(130.dp))
        Text(text = "O",
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center
        )
        Divider(modifier = Modifier.width(130.dp))
    }
}