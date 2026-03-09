package com.example.kmptutorial.network

const val BASE_URL = "https://jsonplaceholder.typicode.com/"
interface ToDoApiService {
    suspend fun getTodos() : Response<List<ToDoDTO>>
}