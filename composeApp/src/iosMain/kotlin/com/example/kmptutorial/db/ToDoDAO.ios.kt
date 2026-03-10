package com.example.kmptutorial.db

import androidx.room.RoomDatabaseConstructor

actual object AppDBConstructor :
    RoomDatabaseConstructor<ToDoDB> {
    actual override fun initialize(): ToDoDB {
        TODO("Not yet implemented")
    }
}