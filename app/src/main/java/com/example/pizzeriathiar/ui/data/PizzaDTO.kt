package com.example.pizzeriathiar.ui.data

data class PizzaDTO(
    val id:Int,
    val nombre:String,
    val precio:Double,
    val tamanyo: SIZE,
    val listaIngredientesPizza:List<Ingrediente>
)