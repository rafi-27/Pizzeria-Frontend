package com.example.pizzeriathiar.ui.login

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pizzeriathiar.R
import com.example.pizzeriathiar.data.model.LoginDTO
import com.example.pizzeriathiar.navigation.AppNavigation
import com.example.pizzeriathiar.navigation.Screen
import com.example.pizzeriathiar.ui.registro.TextoField
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import androidx.lifecycle.viewModelScope

@Composable
fun PantallaLogin(loginViewModel: LoginViewModel, navHostController: NavHostController) {
    val clienteLogin: LoginDTO by loginViewModel.loginDTO.observeAsState(LoginDTO())
    val encender: Boolean by loginViewModel.botonEncendido.observeAsState(false)

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = (MaterialTheme.colorScheme.background))
    ) {
        item {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(300.dp)
                    .padding(top = 50.dp),
                painter = painterResource(R.drawable.logo),
                contentDescription = ""
            )
            //Los errores tienen que estar en los siguentes campos:+
            //nombre email y password

            TextoField(
                KeyboardType.Email,
                "Email",
                { loginViewModel.onClienteChange(clienteLogin.copy(email = it)) },
                clienteLogin.email
            )
            TextoField(
                KeyboardType.Password,
                "Password",
                { loginViewModel.onClienteChange(clienteLogin.copy(password = it)) },
                clienteLogin.password
            )

            Button(onClick = {
                loginViewModel.onRegistrarClick()
                navHostController.navigate(Screen.Home.route)
                bloqueoOnclickLogin()
            },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(80.dp),
                enabled = encender) { Text("Login") }

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
            ) {
                Text(text = "No tienes cuenta aun ")
                Text(text = "registrate aqui.",
                    style = TextStyle(
                        color = Color.Blue,
                        fontSize = 18.sp,
                        textDecoration = TextDecoration.Underline
                    ),
                    modifier = Modifier.clickable { navHostController.navigate(Screen.Registro.route) })
            }
        }
    }
}

suspend fun esperarCincoSegundos(){
    Log.d("Hilos","Hilo principal bloqueado durante 10 segundos.")
    delay(10000)
    Log.d("Hilos","Hilo principal desbloqueado despues de 10 segundos.")
}

fun bloqueoOnclickLogin(){
    viewModelScope.launch (Dispatchers.IO) { //Lanza una corutina
        esperarCincoSegundos()
    }
}
@Preview(showBackground = true)
@Composable
fun PantallaPrincipalLoginPreview() {
    val navController = rememberNavController()
    AppNavigation(navController = navController)
}
