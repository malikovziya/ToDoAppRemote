package com.example.todoappremote.domain.repositories

import com.example.todoappremote.domain.models.ToDoItem

interface ToDoRepository {
    suspend fun getTodos(): List<ToDoItem>

    suspend fun addTodo(todo: ToDoItem)

    suspend fun getTodoByWeekday(weekDay : String) : List<ToDoItem>
}