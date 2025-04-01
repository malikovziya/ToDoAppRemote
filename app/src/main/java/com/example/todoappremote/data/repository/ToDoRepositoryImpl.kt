package com.example.todoappremote.data.repository

import android.util.Log
import com.example.todoappremote.data.local.ToDoDao
import com.example.todoappremote.data.remote.RemoteApiService
import com.example.todoappremote.domain.models.ToDoItem
import com.example.todoappremote.domain.models.toToDoEntity
import com.example.todoappremote.domain.models.toToDoItem
import com.example.todoappremote.domain.repositories.ToDoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class ToDoRepositoryImpl(
    private val apiService: RemoteApiService,
    private val todoDao: ToDoDao
) : ToDoRepository {

    override fun getTodos(): Flow<List<ToDoItem>> = flow {
        try {
            // Then try to fetch from remote
            val remoteTodos = withContext(Dispatchers.IO) { apiService.getTodos() }

            // Update local database (only new/changed items)
            remoteTodos.forEach { remoteTodo ->
                todoDao.insert(remoteTodo) // REPLACE on conflict
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        // First emit local data immediately
        emitAll(todoDao.getAllTodos().map { entities ->
            entities.map { it.toToDoItem() }
        })
    }

    override suspend fun addTodo(todo: ToDoItem) {
        val entity = todo.toToDoEntity()
        // Write to local DB first for instant UI update
        todoDao.insert(entity)

        try {
            // Then sync with remote
            apiService.addTodo(entity)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun getTodoByWeekday(weekDay: String): Flow<List<ToDoItem>> {
        return todoDao.getTodosByDay(weekDay).map { entities ->
            entities.map { it.toToDoItem() }
        }
    }
}