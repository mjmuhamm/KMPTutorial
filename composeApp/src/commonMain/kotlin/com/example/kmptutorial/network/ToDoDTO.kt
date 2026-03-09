package com.example.kmptutorial.network

import kotlinx.serialization.Serializable

@Serializable
data class ToDoDTO(
    val id: Int,
    val userId: Int,
    val title: String,
    val completed: Boolean
)
