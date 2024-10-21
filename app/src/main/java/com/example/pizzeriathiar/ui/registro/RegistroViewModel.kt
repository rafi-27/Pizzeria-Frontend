package com.example.pizzeriathiar.ui.registro

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegistroViewModel:ViewModel() {
    val clienteDTO = MutableLiveData("")

    //Funcion para concatenar
    fun onTextoChange(newText:String){}

}