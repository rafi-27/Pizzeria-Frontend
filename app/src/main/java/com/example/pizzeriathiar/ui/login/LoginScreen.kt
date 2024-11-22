package com.example.pizzeriathiar.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pizzeriathiar.R
import com.example.pizzeriathiar.data.model.LoginDTO
import com.example.pizzeriathiar.navigation.AppNavigation
import com.example.pizzeriathiar.ui.registro.TextoField

@Composable
fun PantallaLogin(loginViewModel: LoginViewModel,navController: NavHostController) {
    val clienteLogin: LoginDTO by loginViewModel.loginDTO.observeAsState(LoginDTO())
    val encender:Boolean by loginViewModel.botonEncendido.observeAsState(false)

    LazyColumn(modifier = Modifier.fillMaxSize().background(color = (MaterialTheme.colorScheme.background))) {
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

            TextoField(KeyboardType.Email, "Email", { loginViewModel.onClienteChange(clienteLogin.copy(email = it)) }, clienteLogin.email)
            TextoField(KeyboardType.Password, "Password", { loginViewModel.onClienteChange(clienteLogin.copy(password = it)) }, clienteLogin.password)

            Button(onClick = {loginViewModel.onRegistrarClick()}, modifier = Modifier.fillMaxWidth().padding(80.dp), enabled = encender) { Text("Login") }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaPrincipalLoginPreview() {
    PantallaLogin(LoginViewModel(), AppNavigation())
}
