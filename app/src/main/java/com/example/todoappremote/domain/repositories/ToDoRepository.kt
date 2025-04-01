package com.example.todoappremote.domain.repositories

import com.example.todoappremote.domain.models.ToDoItem
import kotlinx.coroutines.flow.Flow

interface ToDoRepository {
    fun getTodos(): Flow<List<ToDoItem>>

    suspend fun addTodo(todo: ToDoItem)

    fun getTodoByWeekday(weekDay : String) : Flow<List<ToDoItem>>
}