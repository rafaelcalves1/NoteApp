package com.example.noteapp

import android.app.Application
import androidx.room.Room
import com.example.noteapp.data.data_source.NotaDataBase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {

    companion object {
        var notaDataBase: NotaDataBase? = null
    }

    override fun onCreate() {
        super.onCreate()
        notaDataBase =
            Room.databaseBuilder(this, NotaDataBase::class.java, "my-db").allowMainThreadQueries()
                .build()


    }

}