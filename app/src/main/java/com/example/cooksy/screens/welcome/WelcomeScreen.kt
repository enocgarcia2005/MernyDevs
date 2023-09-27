package com.example.cooksy.screens.welcome

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cooksy.components.DividerSpecial
import com.example.cooksy.components.GoogleButton
import com.example.cooksy.screens.welcome.sections.CarouselSection
import com.example.cooksy.screens.welcome.sections.ImageSection
import com.example.cooksy.screens.welcome.sections.SectionButtons
import com.example.cooksy.ui.theme.CooksyTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun WelcomeScreen() {
    val pagerState = rememberPagerState(initialPage = 0)
    val scope = rememberCoroutineScope()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {
        ImageSection()
        Spacer(modifier = Modifier.height(10.dp))
        CarouselSection(pagerState = pagerState, scope = scope)
        Spacer(modifier = Modifier.height(30.dp))
        SectionButtons()
        Spacer(modifier = Modifier.height(15.dp))
        DividerSpecial()
        Spacer(modifier = Modifier.height(15.dp))
        GoogleButton()
    }
}

@Preview(showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    CooksyTheme {
        WelcomeScreen()
    }
}