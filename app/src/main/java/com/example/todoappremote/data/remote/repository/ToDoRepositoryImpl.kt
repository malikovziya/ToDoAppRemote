package com.example.todoappremote.data.remote.repository

import com.example.todoappremote.data.remote.RemoteApiService
import com.example.todoappremote.domain.models.ToDoItem
import com.example.todoappremote.domain.repositories.ToDoRepository

class ToDoRepositoryImpl(private val apiService: RemoteApiService) : ToDoRepository {
    override suspend fun getTodos(): List<ToDoItem> {
        return apiService.getTodos()
    }

    override suspend fun addTodo(todo: ToDoItem) {
        apiService.addTodo(todo)
    }

    override suspend fun getTodoByWeekday(weekDay: String): List<ToDoItem> {
        val todos = apiService.getTodos()
        return todos.filter { it.weekday == weekDay }
    }
}