package com.example.pizzeriathiar.ui.registro

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pizzeriathiar.data.model.ClienteDTO
import com.example.pizzeriathiar.data.model.ErrorMessege

class RegistroViewModel:ViewModel() {
    val clienteDTO = MutableLiveData<ClienteDTO>()
    val botonEncendido = MutableLiveData(false)
    val mensajeDeError = MutableLiveData<ErrorMessege>()

    //Funcion para concatenar
    fun onClienteChange(newCliente: ClienteDTO){
        mensajeDeError.value = ErrorMessege(
            nombre = if (newCliente.nombre.any{it.isDigit()}&&newCliente.nombre.isNotBlank()) "El nombre no puede tener digitos." else "",
            email = if (!newCliente.email.matches(Regex("^[\\w.-]+@[\\w-]+\\.[A-Za-z]{2,4}$"))&&newCliente.email.isNotBlank()) "Correo invalido" else "",
            password = if (newCliente.password.length<4&&newCliente.password.isNotBlank())"La contraseña debe tener una longitud igual o mayor a 4" else ""
        )

        if (newCliente.nombre.isBlank()||newCliente.dni.isBlank()||newCliente.direccion.isBlank()||newCliente.telefono.isBlank()||newCliente.email.isBlank()||newCliente.password.isBlank()) {
            botonEncendido.value = false
        }else{botonEncendido.value=true}

        clienteDTO.value=newCliente;
    }

    fun onRegistrarClick(){
        Log.d("Botonregistrar","Cliente: ${clienteDTO.value}")
    }
}