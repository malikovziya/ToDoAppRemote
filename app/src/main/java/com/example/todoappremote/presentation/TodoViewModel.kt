package com.example.todoappremote.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoappremote.data.local.ToDoEntity
import com.example.todoappremote.domain.models.ToDoItem
import com.example.todoappremote.domain.models.toToDoItem
import com.example.todoappremote.domain.use_cases.AddTodoUseCase
import com.example.todoappremote.domain.use_cases.GetFilteredTodosUseCase
import com.example.todoappremote.domain.use_cases.GetTodosUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TodoViewModel(
    private val getTodosUseCase: GetTodosUseCase,
    private val addTodoUseCase: AddTodoUseCase,
    private val getFilteredTodosUseCase: GetFilteredTodosUseCase
): ViewModel() {
    private val _allTodos = MutableStateFlow<List<ToDoItem>>(emptyList())
    val allTodos: StateFlow<List<ToDoItem>> = _allTodos

    init {
        getAllTodos()
    }

    fun getAllTodos() {
        viewModelScope.launch {
            getTodosUseCase().collect { result ->
                _allTodos.value = result
            }
        }
    }

    fun insert(todo: ToDoEntity) {
        viewModelScope.launch {
            addTodoUseCase(todo.toToDoItem())
        }
    }

    fun getFilteredTodos(day: String?) {
        viewModelScope.launch {
            if (day != null) {
                getFilteredTodosUseCase(day).collect { result ->
                    _allTodos.value = result
                }
            } else {
                getAllTodos()
            }
        }
    }
}