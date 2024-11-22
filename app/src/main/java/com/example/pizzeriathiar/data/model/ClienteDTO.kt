package com.example.pizzeriathiar.data.model

data class ClienteDTO(
    val id:Int? = null,
    val dni:String="",
    val nombre:String="",
    val direccion:String="",
    val telefono:String="",
    val email:String="",
    val password:String="",
    val listaPedidos:List<PedidoDTO> = emptyList()
)