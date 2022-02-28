package com.example.noteapp.di

import android.app.Application
import androidx.room.Room
import com.example.noteapp.data.data_source.NotaDataBase
import com.example.noteapp.data.data_source.NotaDataBase.Companion.DATABASE_NOME
import com.example.noteapp.data.repository.NotaRepository
import com.example.noteapp.data.repository.NotaRepositoryImpl
import com.example.noteapp.presenter.viewmodel.MainActivityViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNotaDatabase(app: Application): NotaDataBase {
        return Room.databaseBuilder(app, NotaDataBase::class.java, DATABASE_NOME).build()
    }

    @Provides
    @Singleton
    fun provideNotaRepository(db: NotaDataBase): NotaRepository {
        return NotaRepositoryImpl(db.notaDao)
    }

    @Provides
    @Singleton
    fun provideNotaViewModel(repository: NotaRepository): MainActivityViewModel {
        return MainActivityViewModel(
            repository
        )
    }


}