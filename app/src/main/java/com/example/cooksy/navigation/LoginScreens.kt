package com.example.cooksy.navigation
sealed class LoginScreens(
    val route:String
){
    object Welcome: LoginScreens(
        "welcome")
    object Login: LoginScreens(
        "login")
    object Register: LoginScreens(
        "register")

}