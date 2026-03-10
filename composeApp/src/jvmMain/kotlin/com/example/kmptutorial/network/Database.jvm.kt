package com.example.kmptutorial.network

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import com.example.kmptutorial.db.ToDoDB
import java.io.File

//actual object AppDBConstructor :
//    RoomDatabaseConstructor<ToDoDB> {
//    actual override fun initialize(): ToDoDB {
//        TODO("Not yet implemented")
//    }
//}

fun getDatabaseBuilder(): RoomDatabase.Builder<ToDoDB> {
    val dbFile = File(System.getProperty("user.dir"), "todo.db")
    return Room.databaseBuilder<ToDoDB>(
        name = dbFile.absolutePath,
    )
        .fallbackToDestructiveMigration(false)
}