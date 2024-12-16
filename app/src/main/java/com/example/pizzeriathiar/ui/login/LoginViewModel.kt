package com.example.pizzeriathiar.ui.login

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pizzeriathiar.data.model.LoginDTO
import com.example.pizzeriathiar.data.repositories.ClienteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

//import androidx.lifecycle.viewModelScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.delay
//import kotlinx.coroutines.launch

class LoginViewModel(private val clienteRepository: ClienteRepository):ViewModel(){
    val loginDTO = MutableLiveData<LoginDTO>()
    val botonEncendido = MutableLiveData(false)
    val cargando = MutableLiveData(false)

    fun onClienteChange(newCliente: LoginDTO){
        if (newCliente.email.isBlank()||newCliente.password.isBlank()) {
            botonEncendido.value = false
        }else{botonEncendido.value=true}

        loginDTO.value=newCliente;
    }

    fun onLoginClick(callback: (Boolean) -> Unit){
        cargando.value = true
        val clienteActual = loginDTO.value
        if (clienteActual != null) {
            viewModelScope.launch {
                val result =
                    clienteRepository.loginCliente(clienteActual)
                withContext(Dispatchers.Main) {
                    when (result.isSuccess) {
                        true -> {
                            loginDTO.value = result.getOrThrow()
                            callback(true)
                            cargando.value=false
                        }
                        false -> {
                            Log.d("Login", "Error:$result")
                            callback(false)
                            cargando.value=false
                        }
                    }
                }
            }
        }
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