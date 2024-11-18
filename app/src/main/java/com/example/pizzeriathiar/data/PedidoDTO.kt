package com.example.pizzeriathiar.data

import java.util.Date

data class PedidoDTO(
    val id:Int,
    val fecha: Date,
    val precioTotal:Double,
    val estado: EstadoPedido,
    var listaLineaPedido:MutableList<LineaPedidoDTO>
)