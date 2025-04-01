package com.example.todoappremote.data.remote

import com.example.todoappremote.data.local.ToDoEntity
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RemoteApiService {
    @GET("todos")
    suspend fun getTodos(): List<ToDoEntity>

    @POST("todos")
    suspend fun addTodo(@Body todo: ToDoEntity): ToDoEntity
}