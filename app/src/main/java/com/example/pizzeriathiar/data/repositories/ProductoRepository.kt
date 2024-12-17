package com.example.pizzeriathiar.data.repositories

import com.example.pizzeriathiar.data.model.ProductoDTO
import com.example.pizzeriathiar.data.network.ProductoApiServices

class ProductoRepository(private val apiService: ProductoApiServices) {
    suspend fun getProductos(): List<ProductoDTO>
    {
        return apiService.getProductos()

    }
}