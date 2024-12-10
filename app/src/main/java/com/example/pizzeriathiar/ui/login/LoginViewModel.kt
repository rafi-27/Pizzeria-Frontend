package com.example.pizzeriathiar.ui.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pizzeriathiar.data.model.LoginDTO
//import androidx.lifecycle.viewModelScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.delay
//import kotlinx.coroutines.launch


class LoginViewModel:ViewModel(){
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

//    suspend fun esperarCincoSegundos(){
//        Log.d("Hilos","Hilo principal bloqueado durante 10 segundos.")
//        delay(10000)
//        Log.d("Hilos","Hilo principal desbloqueado despues de 10 segundos.")
//    }
//
//    fun bloqueoOnclickLogin(){
//        viewModelScope.launch (Dispatchers.IO) { //Lanza una corutina
//            esperarCincoSegundos()
//        }
//    }
}