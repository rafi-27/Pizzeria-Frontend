package com.example.pizzeriathiar.ui.home

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import com.example.pizzeriathiar.navigation.Screen

@Composable
fun SimpleAlertDialog(navHostController: NavHostController) {
// Estado para controlar si se muestra el diálogo
    var showDialog by remember { mutableStateOf(false) }
// Botón que activa el diálogo
    Button(onClick = { showDialog = true }) {
        Text("Abrir diálogo")
    }
// Muestra el diálogo si showDialog está a true
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = {
                Text(text = "Cierre de sesión")
            },
            text = {
                Text("¿Estás seguro de que quieres cerrar sesión?")
            },
            confirmButton = {
                TextButton(onClick = {
                    showDialog = false
                    navHostController.navigate(Screen.Login.route)
                }) {
                    Text("Sí")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text("No")
                }
            }
        )
    }
}