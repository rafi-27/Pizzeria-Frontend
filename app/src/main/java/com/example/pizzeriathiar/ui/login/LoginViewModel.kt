package com.example.pizzeriathiar.ui.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.pizzeriathiar.data.model.LoginDTO

class LoginViewModel {
    val loginDTO = MutableLiveData<LoginDTO>()
    val botonEncendido = MutableLiveData(false)


    fun onClienteChange(newCliente: LoginDTO){
        if (newCliente.email.isBlank()||newCliente.password.isBlank()) {
            botonEncendido.value = false
        }else{botonEncendido.value=true}

        loginDTO.value=newCliente;
    }

    fun onRegistrarClick(){
        Log.d("BotonLogin","Cliente: ${loginDTO.value}")
    }
}