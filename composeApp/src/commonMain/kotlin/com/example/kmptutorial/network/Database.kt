package com.example.kmptutorial.network

import androidx.room.RoomDatabaseConstructor
import com.example.kmptutorial.db.ToDoDB

//@Suppress("KotlinNoActualForExpect")
expect object AppDBConstructor: RoomDatabaseConstructor<ToDoDB>{
    override fun initialize(): ToDoDB
}

