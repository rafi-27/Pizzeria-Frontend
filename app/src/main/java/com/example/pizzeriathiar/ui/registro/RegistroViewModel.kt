package com.example.pizzeriathiar.ui.registro

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pizzeriathiar.data.ClienteDTO

class RegistroViewModel:ViewModel() {
    val clienteDTO = MutableLiveData<ClienteDTO>()
    val botonEncendido = MutableLiveData(false)

    //Funcion para concatenar
    fun onClienteChange(newCliente:ClienteDTO){
        if (newCliente.nombre.isBlank()||newCliente.dni.isBlank()||newCliente.direccion.isBlank()||newCliente.telefono.isBlank()||newCliente.email.isBlank()||newCliente.password.isBlank()) {
            botonEncendido.value = false
        }else{botonEncendido.value=true}

        clienteDTO.value=newCliente;
    }
}