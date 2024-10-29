package com.example.pizzeriathiar.ui.login

import androidx.lifecycle.MutableLiveData
import com.example.pizzeriathiar.data.ClienteDTO
import com.example.pizzeriathiar.data.ErrorMessege
import com.example.pizzeriathiar.data.LoginDTO

class LoginViewModel {
    val loginDTO = MutableLiveData<LoginDTO>()
    val botonEncendido = MutableLiveData(false)

    fun onClienteChange(newCliente:LoginDTO){
        if (newCliente.email.isBlank()||newCliente.password.isBlank()) {
            botonEncendido.value = false
        }else{botonEncendido.value=true}

        loginDTO.value=newCliente;
    }
}