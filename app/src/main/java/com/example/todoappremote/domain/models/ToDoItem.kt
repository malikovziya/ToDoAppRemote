package com.example.todoappremote.domain.models

data class ToDoItem(
    val id: String,
    val title: String,
    val weekday: String,
    val completed: Boolean,
    val createdAt: String
)