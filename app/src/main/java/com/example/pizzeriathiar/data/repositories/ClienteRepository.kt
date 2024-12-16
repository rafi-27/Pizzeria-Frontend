package com.example.pizzeriathiar.data.repositories

import com.example.pizzeriathiar.data.model.ClienteDTO
import com.example.pizzeriathiar.data.model.LoginDTO
import com.example.pizzeriathiar.data.network.ClienteApiService
import retrofit2.Response

class ClienteRepository(private val apiService: ClienteApiService) {
    suspend fun registrarCliente(cliente: ClienteDTO): Result<ClienteDTO>
    {
        return try {
            val response = apiService.registrarCliente(cliente)
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun loginCliente(clienteLogin: LoginDTO): Result<LoginDTO>
    {
        return try {
            val response = apiService.loginCliente(clienteLogin)
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun actualizarCliente(cliente: ClienteDTO): Result<ClienteDTO>
    {
        return try {
            val response = apiService.registrarCliente(cliente)
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}