package com.example.pizzeriathiar.data.repositories;

import com.example.pizzeriathiar.data.model.ClienteDTO;
import com.example.pizzeriathiar.data.network.ClienteApiService;

import kotlin.Result;

class ClienteRepository(private val apiService: ClienteApiService) {
    suspend fun registrarCliente(cliente: ClienteDTO): Result<ClienteDTO> {
        return try {
        val response = apiService.registrarCliente(cliente)
        Result.success(response)
    } catch (e: Exception) {
        Result.failure(e)
    }

    }
}