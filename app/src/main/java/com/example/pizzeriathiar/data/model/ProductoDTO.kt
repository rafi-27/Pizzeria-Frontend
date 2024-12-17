package com.example.pizzeriathiar.data.model

data class ProductoDTO (
    val id:Int?=null,
    val nombre:String="",
    val precio:Double=0.0,
    var size: SIZE? = null,
    val ingredientes:List<Ingrediente> = emptyList<Ingrediente>(),
    val tipo: TipoProducto?=null
)