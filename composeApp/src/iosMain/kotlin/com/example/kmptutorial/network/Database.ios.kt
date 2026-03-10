package com.example.kmptutorial.network

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import com.example.kmptutorial.db.ToDoDB
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask

//actual object AppDBConstructor :
//    RoomDatabaseConstructor<ToDoDB> {
//    actual override fun initialize(): ToDoDB {
//        TODO("Not yet implemented")
//    }
//}

fun getDatabaseBuilder(): RoomDatabase.Builder<ToDoDB> {
    val dbFilePath = documentDirectory() + "/todo.db"
    return Room.databaseBuilder<ToDoDB>(
        name = dbFilePath,
    )
}

@OptIn(ExperimentalForeignApi::class)
private fun documentDirectory() : String {
    val documentDirectory = NSFileManager.defaultManager.URLForDirectory(
        directory = NSDocumentDirectory,
        inDomain = NSUserDomainMask,
        appropriateForURL = null,
        create = false,
        error = null
    )
    return requireNotNull(documentDirectory?.path)
}


