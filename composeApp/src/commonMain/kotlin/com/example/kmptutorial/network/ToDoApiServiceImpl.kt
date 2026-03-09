package com.example.kmptutorial.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.accept
import io.ktor.client.request.get
import io.ktor.http.ContentType

class ToDoApiServiceImpl(private val client : HttpClient) : ToDoApiService {
    override suspend fun getTodos(): Response<List<ToDoDTO>> {
        try {
            val todos =  client.get("${BASE_URL}todos") {
                accept(ContentType.Application.Json)
        }
            return Response.Success(todos.body())

        } catch (e: Exception) {
            return Response.Error(e.message.toString())
        }
    }
}