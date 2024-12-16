package com.example.pizzeriathiar.ui.home

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.pizzeriathiar.navigation.Screen

@Composable
fun SimpleAlertDialog(navHostController: NavHostController, onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = {
            Text(text = "Cierre de sesión")
        },
        text = {
            Text("¿Estás seguro de que quieres cerrar sesión?")
        },
        confirmButton = {
            TextButton(onClick = {
                onDismiss()
                navHostController.navigate(Screen.Login.route) {
                    popUpTo(Screen.Home.route) { inclusive = true }
                }
            }) {
                Text("Sí")
            }
        },
        dismissButton = {
            TextButton(onClick = { onDismiss() }) {
                Text("No")
            }
        }
    )
}