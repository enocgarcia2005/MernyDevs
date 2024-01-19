package com.example.cooksy.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cooksy.screens.login.LoginScreen
import com.example.cooksy.screens.login.LoginScreenViewModel
import com.example.cooksy.screens.register.RegisterScreen
import com.example.cooksy.screens.welcome.WelcomeScreen

@Composable
fun LoginNavController(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = LoginScreens.Welcome.route){
        composable(LoginScreens.Welcome.route){
            WelcomeScreen(modifier, navController)
        }
         composable(LoginScreens.Login.route){
            LoginScreen(modifier, navController, LoginScreenViewModel())
        }
         composable(LoginScreens.Register.route){
            RegisterScreen(modifier, navController,LoginScreenViewModel())
        }
    }
}