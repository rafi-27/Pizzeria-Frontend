package com.example.pizzeriathiar.data.model

data class PizzaDTO(
    val id:Int,
    val nombre:String,
    val precio:Double,
    val tamanyo: SIZE,
    val listaIngredientesPizza:List<Ingrediente>
)