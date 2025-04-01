package com.example.todoappremote.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {
    @Query("SELECT * FROM todo_table1")
    fun getAllTodos(): Flow<List<ToDoEntity>>

    @Query("SELECT * FROM todo_table1 WHERE weekday = :day")
    fun getTodosByDay(day: String): Flow<List<ToDoEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(todo: ToDoEntity)
}