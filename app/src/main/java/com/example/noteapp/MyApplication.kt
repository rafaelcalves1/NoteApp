package com.example.noteapp

import android.app.Application
import com.example.noteapp.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            val listModules = listOf(
                AppModule.dataBaseModule,
                AppModule.useCasesModule,
                AppModule.viewModelModule,
                AppModule.repositoryModule
            )
            modules(listModules)
        }
    }

}