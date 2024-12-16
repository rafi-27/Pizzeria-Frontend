package com.example.pizzeriathiar.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pizzeriathiar.data.network.ClienteApiService
import com.example.pizzeriathiar.data.repositories.ClienteRepository
import com.example.pizzeriathiar.ui.home.HomeViewModel
import com.example.pizzeriathiar.ui.home.PantallaProducto
import com.example.pizzeriathiar.ui.login.LoginViewModel
import com.example.pizzeriathiar.ui.login.PantallaLogin
import com.example.pizzeriathiar.ui.registro.PantallaRegistro
import com.example.pizzeriathiar.ui.registro.RegistroViewModel

@Composable
fun AppNavigation(navController: NavHostController,clienteRepository: ClienteRepository){
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ){
        composable(Screen.Login.route){
            PantallaLogin(
                loginViewModel = LoginViewModel(),
                navHostController = navController
            )
        }

        composable(Screen.Registro.route) {
            PantallaRegistro(
                registroViewModel = RegistroViewModel(clienteRepository),
                navController = navController
            )
        }

        composable(Screen.Home.route){
            PantallaProducto(
                homeViewModel = HomeViewModel(),
                navHostController = navController
            )
        }

        composable(Screen.Logout.route) {
            PantallaLogin(
                loginViewModel = LoginViewModel(),
                navHostController = navController
            )
        }
    }
}