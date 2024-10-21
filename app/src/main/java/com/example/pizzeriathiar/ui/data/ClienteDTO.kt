package com.example.pizzeriathiar.ui.data

data class ClienteDTO(
    val id:Int,
    val dni:String,
    val nombre:String,
    val direccion:String,
    val telefono:String,
    val email:String,
    val password:String,
    val listaPedidos:List<PedidoDTO>
)