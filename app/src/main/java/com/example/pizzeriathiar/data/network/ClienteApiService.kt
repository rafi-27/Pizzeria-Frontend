package com.example.pizzeriathiar.data.network

import com.example.pizzeriathiar.data.model.ClienteDTO
import com.example.pizzeriathiar.data.model.LoginDTO
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface ClienteApiService {
    @POST("/clientes/registro")
    suspend fun registrarCliente(@Body cliente: ClienteDTO): ClienteDTO
    @POST("/clientes/login")
    suspend fun loginCliente(@Body loginDTO: LoginDTO): LoginDTO
    @PUT("/clientes/actualizar")
    suspend fun actualizarCliente(@Body cliente: ClienteDTO): ClienteDTO
    @GET("/clientes")
    suspend fun getUsers(): Result<List<ClienteDTO>>
}