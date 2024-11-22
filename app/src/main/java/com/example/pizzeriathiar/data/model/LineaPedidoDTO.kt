package com.example.pizzeriathiar.data.model

data class LineaPedidoDTO(
    val id:Int?,
    val cantidad:Int,
    val productoDTO: ProductoDTO
)