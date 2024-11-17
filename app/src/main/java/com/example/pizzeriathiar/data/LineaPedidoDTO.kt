package com.example.pizzeriathiar.data

data class LineaPedidoDTO(
    val id:Int?,
    val cantidad:Int,
    val productoDTO: ProductoDTO
)