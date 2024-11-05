package com.example.pizzeriathiar.data

data class ProductoDTO (
    val id:Int?=null,
    val nombre:String="",
    val precio:Double=0.0,
    val tamanyo: SIZE? = null,
    val listaIngredientesProducto:List<Ingrediente> = emptyList(),
    val tipo:TipoProducto?=null
)