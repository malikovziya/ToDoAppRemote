package com.example.todoappremote.domain.models

import com.example.todoappremote.data.local.ToDoEntity

data class ToDoItem(
    val id: Int = 0,
    val title: String,
    val weekday: String,
    val completed: Boolean
)

// Mappers for converting between Entity <-> Domain Model
fun ToDoEntity.toToDoItem(): ToDoItem {
    return ToDoItem(
        id = this.id,
        title = this.title,
        weekday = this.weekday,
        completed = this.completed
    )
}

fun ToDoItem.toToDoEntity(): ToDoEntity {
    return ToDoEntity(
        id = this.id,
        title = this.title,
        weekday = this.weekday,
        completed = this.completed
    )
}