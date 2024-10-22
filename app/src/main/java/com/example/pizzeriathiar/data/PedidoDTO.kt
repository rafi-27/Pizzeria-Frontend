package com.example.pizzeriathiar.data

import java.time.LocalDateTime

data class PedidoDTO(
    val id:Int,
    val fecha:LocalDateTime,
    val precio:Double,
    val estado: EstadoPedido,
    val listaLineaPedido:List<LineaPedidoDTO>
)