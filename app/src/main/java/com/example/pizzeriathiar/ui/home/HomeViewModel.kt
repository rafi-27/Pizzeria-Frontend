package com.example.pizzeriathiar.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.pizzeriathiar.data.Ingrediente
import com.example.pizzeriathiar.data.LoginDTO
import com.example.pizzeriathiar.data.ProductoDTO
import com.example.pizzeriathiar.data.SIZE
import com.example.pizzeriathiar.data.TipoProducto

class HomeViewModel {
    val productosDTO = MutableLiveData<List<ProductoDTO>>()

    init {
        cargarProductos()
    }

    fun cargarProductos(){
        var listaProductos:List<ProductoDTO> = listOf(
            ProductoDTO(1,"Pizza kebab",15.0,SIZE.PEQUEÑA, listOf(Ingrediente(11,"Pizza", listOf("PAler1","PAler12"))),TipoProducto.PIZZA),
            ProductoDTO(2,"Pasta peperoni",20.0,SIZE.PEQUEÑA, listOf(Ingrediente(12,"Pasta", listOf("Aler1","Aler12"))),TipoProducto.PASTA),
            ProductoDTO(3,"Pizza kebab",15.0,SIZE.PEQUEÑA, listOf(Ingrediente(13,"Bebia", listOf("BAler1","BAler12"))),TipoProducto.BEBIDA),
            ProductoDTO(4,"Pizza kebab",15.0,SIZE.PEQUEÑA, listOf(),TipoProducto.PIZZA)
        )
    }

}