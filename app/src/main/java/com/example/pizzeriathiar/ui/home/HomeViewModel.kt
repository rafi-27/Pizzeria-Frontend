package com.example.pizzeriathiar.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.pizzeriathiar.data.EstadoPedido
import com.example.pizzeriathiar.data.Ingrediente
import com.example.pizzeriathiar.data.LineaPedidoDTO
import com.example.pizzeriathiar.data.PedidoDTO
import com.example.pizzeriathiar.data.ProductoDTO
import com.example.pizzeriathiar.data.SIZE
import com.example.pizzeriathiar.data.TipoProducto
import java.util.Date

class HomeViewModel {
    val productosDTO = MutableLiveData<List<ProductoDTO>>()
    var cantidadCarrito = MutableLiveData<Int>(0)
    var pedido = MutableLiveData<PedidoDTO>(null)

    init {
        cargarProductos()
    }

    fun cargarProductos(){
        var listaProductos:List<ProductoDTO> = listOf(
            ProductoDTO(1,"Pizza kebab",15.0,SIZE.PEQUEÑA, listOf(Ingrediente(11,"Tomate", listOf()),Ingrediente(11,"Mozarella", listOf())),TipoProducto.PIZZA),
            ProductoDTO(2,"Pasta peperoni",20.0,SIZE.PEQUEÑA, listOf(Ingrediente(12,"Ingrediente Pasta", listOf())),TipoProducto.PASTA),
            ProductoDTO(3,"Power king",15.0,SIZE.PEQUEÑA, listOf(),TipoProducto.BEBIDA),
            ProductoDTO(4,"Pizza kebab",15.0,SIZE.PEQUEÑA, listOf(Ingrediente(12,"Ingrediente pizza 2", listOf())),TipoProducto.PIZZA),
            ProductoDTO(2,"Pasta peperoni",20.0,SIZE.PEQUEÑA, listOf(Ingrediente(12,"Ingrediente Pasta", listOf())),TipoProducto.PASTA),
            ProductoDTO(2,"Pasta peperoni",20.0,SIZE.PEQUEÑA, listOf(Ingrediente(12,"Ingrediente Pasta", listOf())),TipoProducto.PASTA),
            ProductoDTO(1,"Pizza kebab",15.0,SIZE.PEQUEÑA, listOf(Ingrediente(11,"Tomate", listOf()),Ingrediente(11,"Mozarella", listOf())),TipoProducto.PIZZA),
            ProductoDTO(3,"Power king",15.0,SIZE.PEQUEÑA, listOf(),TipoProducto.BEBIDA),
            ProductoDTO(3,"Power king",15.0,SIZE.PEQUEÑA, listOf(),TipoProducto.BEBIDA)
        )
        productosDTO.value=listaProductos
    }

    fun addCarritoFun(cantidad:Int,productoDTOParam: ProductoDTO,tam:SIZE?){
        if (pedido.value == null){
            pedido.value = PedidoDTO(1, Date(),0.0, EstadoPedido.PENDIENTE, mutableListOf())

            productoDTOParam.tamanyo = tam
            pedido.value?.listaLineaPedido?.add(LineaPedidoDTO(null, cantidad = cantidad, productoDTO = productoDTOParam))
            cantidadCarrito.value = cantidadCarrito.value?.plus(cantidad)

            Log.d("Tag Pedido","Pedido: ${pedido.value}")
        }else{
            productoDTOParam.tamanyo = tam
            pedido.value?.listaLineaPedido?.add(LineaPedidoDTO(null, cantidad = cantidad, productoDTO = productoDTOParam))
            cantidadCarrito.value = cantidadCarrito.value?.plus(cantidad)
            Log.d("Tag Pedido","Pedido: ${pedido.value}")
        }
    }
}


