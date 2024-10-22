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
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pizzeriathiar.R
import com.example.pizzeriathiar.data.ClienteDTO
import androidx.compose.runtime.livedata.observeAsState



@Composable
fun TextoField(teclado:KeyboardType=KeyboardType.Text,label:String){
    OutlinedTextField(
        value = "",
        keyboardOptions = KeyboardOptions(keyboardType =  teclado ),
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        label = { Text(label) },
        trailingIcon = {if (teclado == KeyboardType.Password)
            IconButton(onClick = {}) { Icon(
                imageVector = Icons.Filled.Visibility,
                contentDescription = "")}},
        onValueChange = {}
    )
}


@Composable
fun PantallaRegistro(registroViewModel: RegistroViewModel){
    val cliente: ClienteDTO by registroViewModel.clienteDTO.observeAsState(ClienteDTO())

    LazyColumn {
        item {
            Image(
                modifier = Modifier.fillMaxWidth().size(300.dp).padding(top = 50.dp),
                painter = painterResource(R.drawable.logo),
                contentDescription = ""
            )

            TextoField(KeyboardType.Text,"Nombre")
            TextoField(KeyboardType.Text,"DNI")
            TextoField(KeyboardType.Text,"Direccion")
            TextoField(KeyboardType.Number,"Telefono")
            TextoField(KeyboardType.Text,"Email")
            TextoField(KeyboardType.Password,"Password")

            Button(onClick = {}, modifier = Modifier.fillMaxWidth().padding(80.dp)) { Text("Registar") }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaPrincipalRegistroPreview(){
    PantallaRegistro(RegistroViewModel())
}