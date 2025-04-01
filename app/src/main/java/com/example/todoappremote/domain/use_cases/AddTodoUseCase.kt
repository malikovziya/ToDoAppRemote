package com.example.todoappremote.domain.use_cases

import com.example.todoappremote.domain.models.ToDoItem
import com.example.todoappremote.domain.repositories.ToDoRepository

class AddTodoUseCase(private val repository: ToDoRepository) {
    suspend operator fun invoke(todo: ToDoItem) = repository.addTodo(todo)
}