package com.example.kmptutorial.db

import androidx.room.ConstructedBy
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import com.example.kmptutorial.network.AppDBConstructor
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDAO {
    @Query("Select * from todo")
    fun getAll() : Flow<List<ToDoEntity>>

    @Insert(onConflict = REPLACE)
    suspend fun insert(todos : List<ToDoEntity>)
}

@Database(entities = [ToDoEntity::class], version = 1)
@ConstructedBy(AppDBConstructor::class)
abstract class ToDoDB : RoomDatabase() {
    abstract fun getTodoDao() : ToDoDAO
}


