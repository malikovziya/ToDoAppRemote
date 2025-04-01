package com.example.todoappremote

import android.app.Application
import com.example.todoappremote.di.dataModule
import com.example.todoappremote.di.domainModule
import com.example.todoappremote.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TodoApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@TodoApplication)
            modules(
                dataModule,
                domainModule,
                presentationModule
            )
        }
    }
}