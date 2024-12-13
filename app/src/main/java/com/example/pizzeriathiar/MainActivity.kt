package com.example.pizzeriathiar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.compose.PizzeriaThiarTheme
import com.example.pizzeriathiar.data.network.RetrofitInstance
import com.example.pizzeriathiar.data.repositories.ClienteRepository
import com.example.pizzeriathiar.navigation.AppNavigation
import com.example.pizzeriathiar.ui.home.HomeViewModel
import com.example.pizzeriathiar.ui.home.PantallaProducto
import com.example.pizzeriathiar.ui.login.LoginViewModel
import com.example.pizzeriathiar.ui.login.PantallaLogin
import com.example.pizzeriathiar.ui.registro.PantallaRegistro
import com.example.pizzeriathiar.ui.registro.RegistroViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PizzeriaThiarTheme {
                val navController = rememberNavController()
                //PantallaRegistro(RegistroViewModel(ClienteRepository(RetrofitInstance.clienteApi)),navController)
                AppNavigation(navController = navController,(ClienteRepository(RetrofitInstance.clienteApi)))
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    PizzeriaThiarTheme {
//        Greeting("Android")
//    }
//}