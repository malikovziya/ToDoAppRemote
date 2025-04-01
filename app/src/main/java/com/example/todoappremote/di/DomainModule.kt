package com.example.todoappremote.di

import com.example.todoappremote.domain.use_cases.AddTodoUseCase
import com.example.todoappremote.domain.use_cases.GetFilteredTodosUseCase
import com.example.todoappremote.domain.use_cases.GetTodosUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetTodosUseCase(get()) }
    factory { AddTodoUseCase(get()) }
    factory { GetFilteredTodosUseCase(get()) }
}