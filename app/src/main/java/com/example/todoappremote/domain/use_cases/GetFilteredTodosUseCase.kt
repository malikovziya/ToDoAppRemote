package com.example.todoappremote.domain.use_cases

import com.example.todoappremote.domain.models.ToDoItem
import com.example.todoappremote.domain.repositories.ToDoRepository
import kotlinx.coroutines.flow.Flow

class GetFilteredTodosUseCase(private val repository: ToDoRepository) {
    operator fun invoke(day: String): Flow<List<ToDoItem>> = repository.getTodoByWeekday(day)
}