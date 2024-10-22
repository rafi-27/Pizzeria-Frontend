package com.example.pizzeriathiar.ui.registro

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pizzeriathiar.data.ClienteDTO

class RegistroViewModel:ViewModel() {
    val clienteDTO = MutableLiveData<ClienteDTO>()

    //Funcion para concatenar
    fun onTextoChange(newText:String){}

}