package com.example.pizzeriathiar.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pizzeriathiar.data.network.ClienteApiService
import com.example.pizzeriathiar.data.repositories.ClienteRepository
import com.example.pizzeriathiar.data.repositories.ProductoRepository
import com.example.pizzeriathiar.ui.home.HomeViewModelprivate
import com.example.pizzeriathiar.ui.home.PantallaProducto
import com.example.pizzeriathiar.ui.login.LoginViewModel
import com.example.pizzeriathiar.ui.login.PantallaLogin
import com.example.pizzeriathiar.ui.registro.PantallaRegistro
import com.example.pizzeriathiar.ui.registro.RegistroViewModel

@Composable
fun AppNavigation(navController: NavHostController,clienteRepository: ClienteRepository,productoRepository: ProductoRepository){
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ){
        composable(Screen.Login.route){
            PantallaLogin(
                loginViewModel = LoginViewModel(clienteRepository),
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
                homeViewModel = HomeViewModelprivate(productoRepository),
                navHostController = navController
            )
        }

        composable(Screen.Logout.route) {
            PantallaLogin(
                loginViewModel = LoginViewModel(clienteRepository),
                navHostController = navController
            )
        }
    }
}