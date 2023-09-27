package com.example.cooksy.screens.welcome.sections

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.cooksy.R

@Composable
fun ImageSection() {
    Image(
        painter = painterResource(id = R.drawable.imagotipo) ,
        contentDescription = stringResource(R.string.logo)
    )
    Image(
        painter = painterResource(id = R.drawable.ilust_inicio) ,
        contentDescription = stringResource(R.string.logo)
    )
}