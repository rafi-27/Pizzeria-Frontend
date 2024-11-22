package com.example.pizzeriathiar.data.model

/**
 * (1 punto) Ejercicio 2. Crea una clase KebabDTO, que sea coherente con el
 * diagrama de clases de la práctica 1, considerándose un tipo de producto
 * adicional de la pizzeria. Además, el kebab guardará la siguiente información:
 * • ingredientes:lista de ingredientes.
 * • size:tamaño GRANDE, MEDIANA Y PEQUEÑA.
 * • carne: TIPO_CARNE (pollo, ternera, mixta)
 */

data class KebabDTO (
    val ingrediente:List<Ingrediente>,
    val tamanio: SIZE,
    val tipoCarne: TIPO_CARNE,
    val precio:Double
)