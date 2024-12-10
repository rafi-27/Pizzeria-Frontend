package com.example.pizzeriathiar.navigation

sealed class Screen(val route: String){
    object Registro : Screen("registro")
    object Login : Screen("login")
    object Home : Screen("home")
    object Logout : Screen("logout")
    val screnns = listOf(Screen.Home,Screen.Logout)
}