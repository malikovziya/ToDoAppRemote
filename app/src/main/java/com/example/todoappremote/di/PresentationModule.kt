package com.example.todoappremote.di

import com.example.todoappremote.presentation.TodoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        TodoViewModel(
            getTodosUseCase = get(),
            addTodoUseCase = get(),
            getFilteredTodosUseCase = get()
        )
    }
}