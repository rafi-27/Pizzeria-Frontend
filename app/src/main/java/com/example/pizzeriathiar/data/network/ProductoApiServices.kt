package com.example.pizzeriathiar.data.network

import com.example.pizzeriathiar.data.model.ClienteDTO
import com.example.pizzeriathiar.data.model.ProductoDTO
import retrofit2.http.GET

interface ProductoApiServices {
    @GET("/productos")
    suspend fun getProductos(): List<ProductoDTO>
}