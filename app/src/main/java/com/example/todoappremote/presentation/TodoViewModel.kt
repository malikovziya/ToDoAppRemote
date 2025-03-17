package com.example.todoappremote.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoappremote.domain.models.ToDoItem
import com.example.todoappremote.domain.repositories.ToDoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class TodoViewModel(private val todoRepository: ToDoRepository): ViewModel() {
    val allTodos = MutableStateFlow<List<ToDoItem>>(emptyList())

    fun getAllTodos() {
        viewModelScope.launch {
            val result = todoRepository.getTodos()
            allTodos.value = result
        }
    }

    fun insert(todo: ToDoItem) {
        viewModelScope.launch {
            todoRepository.addTodo(todo)
            getAllTodos()
        }
    }

    fun getFilteredTodos(day: String?) {
        if (day != null) {
            viewModelScope.launch {
                val result = todoRepository.getTodoByWeekday(day)
                allTodos.value = result
            }
        } else {
            getAllTodos()
        }
    }
}