package com.example.todoappremote.data.remote

import com.example.todoappremote.domain.models.ToDoItem
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RemoteApiService {
    @GET("todos")
    suspend fun getTodos(): List<ToDoItem>

    @POST("todos")
    suspend fun addTodo(@Body todo: ToDoItem): ToDoItem
}
