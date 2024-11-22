package com.example.pizzeriathiar.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pizzeriathiar.ui.home.HomeViewModel
import com.example.pizzeriathiar.ui.home.PantallaProducto
import com.example.pizzeriathiar.ui.login.LoginViewModel
import com.example.pizzeriathiar.ui.login.PantallaLogin
import com.example.pizzeriathiar.ui.registro.PantallaRegistro
import com.example.pizzeriathiar.ui.registro.RegistroViewModel

@Composable
fun AppNavigation(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ){
        composable(Screen.Login.route){
            PantallaLogin(
                loginViewModel = LoginViewModel(),
                navController = navController
            )
        }

        composable(Screen.Login.route){
            PantallaRegistro(
                registroViewModel = RegistroViewModel(),
                navController = navController
            )
        }

        composable(Screen.Login.route){
            PantallaProducto(
                homeViewModel = HomeViewModel(),
                navController = navController
            )
        }

    }
}