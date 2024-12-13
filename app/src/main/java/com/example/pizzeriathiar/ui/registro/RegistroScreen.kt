package com.example.pizzeriathiar.ui.registro

import android.view.textclassifier.TextLinks.TextLink
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pizzeriathiar.R
import com.example.pizzeriathiar.data.model.ClienteDTO
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pizzeriathiar.data.model.ErrorMessege
import com.example.pizzeriathiar.data.network.RetrofitInstance
import com.example.pizzeriathiar.data.repositories.ClienteRepository
import com.example.pizzeriathiar.navigation.AppNavigation
import com.example.pizzeriathiar.navigation.Screen
import org.w3c.dom.Text


@Composable
fun TextoField(
    teclado: KeyboardType = KeyboardType.Text,
    label: String,
    onClietneChange: (String) -> Unit,
    valor: String,
    error: String = ""
) {
    var hidden by remember { mutableStateOf(true) }

    OutlinedTextField(
        keyboardOptions = KeyboardOptions(keyboardType = teclado),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp, horizontal = 16.dp),
        label = { Text(label) },
        visualTransformation = if (teclado == KeyboardType.Password && hidden) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            if (teclado == KeyboardType.Password)
                IconButton(onClick = {
                    if (hidden) {
                        hidden = false
                    } else {
                        hidden = true
                    }
                }) {
                    Icon(
                        imageVector = if (hidden) Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                        contentDescription = ""
                    )
                }
        },
        onValueChange = onClietneChange,
        value = valor
    )
    Text(
        color = MaterialTheme.colorScheme.error,
        text = error,
        fontSize = 12.sp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 2.dp)
            .padding(horizontal = 16.dp)
    )
}


@Composable
fun PantallaRegistro(registroViewModel: RegistroViewModel, navController: NavHostController) {
    val cliente: ClienteDTO by registroViewModel.clienteDTO.observeAsState(ClienteDTO())
    val encender: Boolean by registroViewModel.botonEncendido.observeAsState(false)
    val errorTipo: ErrorMessege by registroViewModel.mensajeDeError.observeAsState(ErrorMessege())

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
                KeyboardType.Text,
                "Nombre",
                { registroViewModel.onClienteChange(cliente.copy(nombre = it)) },
                cliente.nombre,
                errorTipo.nombre
            )
            TextoField(
                KeyboardType.Text,
                "DNI",
                { registroViewModel.onClienteChange(cliente.copy(dni = it)) },
                cliente.dni
            )
            TextoField(
                KeyboardType.Text,
                "Direccion",
                { registroViewModel.onClienteChange(cliente.copy(direccion = it)) },
                cliente.direccion
            )
            TextoField(
                KeyboardType.Number,
                "Telefono",
                { registroViewModel.onClienteChange(cliente.copy(telefono = it)) },
                cliente.telefono
            )
            TextoField(
                KeyboardType.Email,
                "Email",
                { registroViewModel.onClienteChange(cliente.copy(email = it)) },
                cliente.email,
                errorTipo.email
            )
            TextoField(
                KeyboardType.Password,
                "Password",
                { registroViewModel.onClienteChange(cliente.copy(password = it)) },
                cliente.password,
                errorTipo.password
            )

            Button(
                onClick = {
                    registroViewModel.onRegistrarClick()
                    navController.navigate(Screen.Home.route)
                }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp, start = 70.dp, end = 70.dp), enabled = encender
            )
            {
                Text("Registar")
            }

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
            ) {
                Text(text = "Si ya tienes cuenta ")
                Text(text = "logeate", style = TextStyle(
                    color = Color.Blue,
                    fontSize = 18.sp,
                    textDecoration = TextDecoration.Underline
                ), modifier = Modifier.clickable { navController.navigate(Screen.Login.route) })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaPrincipalRegistroPreview() {
    val navController = rememberNavController()
    AppNavigation(navController = navController,(ClienteRepository(RetrofitInstance.clienteApi)))
}