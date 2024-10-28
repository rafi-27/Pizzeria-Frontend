package com.example.pizzeriathiar.ui.registro

import androidx.compose.foundation.Image
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
import com.example.pizzeriathiar.data.ClienteDTO
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.pizzeriathiar.data.ErrorMessege


@Composable
fun TextoField(teclado:KeyboardType=KeyboardType.Text,label:String,onClietneChange:(String)->Unit,valor:String,error:String=""){
    var mostrar by remember { mutableStateOf(Icons.Filled.VisibilityOff) }
    var hidden by remember { mutableStateOf(false) }


    OutlinedTextField(
        keyboardOptions = KeyboardOptions(keyboardType =  teclado ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        label = { Text(label) },
        visualTransformation = if (hidden) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {if (teclado == KeyboardType.Password)
            IconButton(onClick = {
                if (mostrar == Icons.Filled.VisibilityOff) { mostrar = Icons.Filled.Visibility; hidden = false
                } else{ mostrar = Icons.Filled.VisibilityOff; hidden = true}
            }) {
                Icon(
                imageVector = mostrar,
                contentDescription = "")}},
        onValueChange = onClietneChange,
        value = valor
    )
    Text(
        color = MaterialTheme.colorScheme.error,
        text = error,
        modifier = Modifier.fillMaxWidth().padding(16.dp)
    )
}


@Composable
fun PantallaRegistro(registroViewModel: RegistroViewModel){
    val cliente: ClienteDTO by registroViewModel.clienteDTO.observeAsState(ClienteDTO())
    val encender: Boolean by registroViewModel.botonEncendido.observeAsState(false)
    val errorTipo: ErrorMessege by registroViewModel.mensajeDeError.observeAsState(ErrorMessege())

    LazyColumn {
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

            TextoField(KeyboardType.Text,"Nombre",{registroViewModel.onClienteChange(cliente.copy(nombre = it))},cliente.nombre,errorTipo.nombre)
            TextoField(KeyboardType.Text,"DNI",{registroViewModel.onClienteChange(cliente.copy(dni = it))},cliente.dni)
            TextoField(KeyboardType.Text,"Direccion",{registroViewModel.onClienteChange(cliente.copy(direccion = it))},cliente.direccion)
            TextoField(KeyboardType.Number,"Telefono",{registroViewModel.onClienteChange(cliente.copy(telefono = it))},cliente.telefono)
            TextoField(KeyboardType.Email,"Email",{registroViewModel.onClienteChange(cliente.copy(email = it))},cliente.email,errorTipo.email)
            TextoField(KeyboardType.Password,"Password",{registroViewModel.onClienteChange(cliente.copy(password = it))},cliente.password,errorTipo.password)

            Button(onClick = {}, modifier = Modifier
                .fillMaxWidth()
                .padding(80.dp), enabled = encender) { Text("Registar")}

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaPrincipalRegistroPreview(){
    PantallaRegistro(RegistroViewModel())
}