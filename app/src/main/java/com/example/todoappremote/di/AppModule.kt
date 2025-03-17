package com.example.todoappremote.di

import com.example.todoappremote.data.remote.RetrofitClient
import com.example.todoappremote.data.remote.repository.ToDoRepositoryImpl
import com.example.todoappremote.domain.repositories.ToDoRepository
import com.example.todoappremote.presentation.TodoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // Provide the RemoteApiService instance (RetrofitClient)
    single { RetrofitClient.apiService }

    // Provide Repository instance
    single<ToDoRepository> { ToDoRepositoryImpl(apiService = get()) }

    // Provide ViewModel instance
    viewModel { TodoViewModel(get()) }
}
