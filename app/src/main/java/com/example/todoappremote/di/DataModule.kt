package com.example.todoappremote.di

import android.content.Context
import com.example.todoappremote.data.local.ToDoDatabase
import com.example.todoappremote.data.remote.RetrofitClient
import com.example.todoappremote.data.repository.ToDoRepositoryImpl
import com.example.todoappremote.domain.repositories.ToDoRepository
import org.koin.dsl.module

val dataModule = module {
    single { RetrofitClient.apiService }

    single {
        val context = get<Context>()
        ToDoDatabase.getDatabase(context)
    }

    single { get<ToDoDatabase>().todoDao() }

    single<ToDoRepository> {
        ToDoRepositoryImpl(
            apiService = get(),
            todoDao = get()
        )
    }
}