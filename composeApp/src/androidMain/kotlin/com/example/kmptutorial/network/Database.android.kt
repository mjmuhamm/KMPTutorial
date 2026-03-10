package com.example.kmptutorial.network

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import com.example.kmptutorial.db.ToDoDB

//actual object AppDBConstructor :
//    RoomDatabaseConstructor<ToDoDB> {
//    actual override fun initialize(): ToDoDB {
//        TODO("Not yet implemented")
//    }
//}

fun getDatabaseBuilder(context: Context): RoomDatabase.Builder<ToDoDB> {
    val appContext = context.applicationContext
    val dbFile = appContext.getDatabasePath("todo.db")
    return Room.databaseBuilder<ToDoDB>(
        context,
        name = dbFile.absolutePath,
    )
        .fallbackToDestructiveMigration(false)
}