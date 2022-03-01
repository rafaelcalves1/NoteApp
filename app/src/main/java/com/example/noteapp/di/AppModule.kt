package com.example.noteapp.di

import android.app.Application
import androidx.room.Room
import com.example.noteapp.data.data_source.NotaDataBase
import com.example.noteapp.data.data_source.NotaDataBase.Companion.DATABASE_NOME
import com.example.noteapp.domain.repository.NotaRepository
import com.example.noteapp.data.repository.NotaRepositoryImpl
import com.example.noteapp.domain.use_cases.*
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
    fun provideNotaUseCases(repository: NotaRepository): NotasUseCases {
        return NotasUseCases(
            pegaNotasUseCase = PegaNotasUseCase(repository),
            deleteNotaUseCase = DeleteNotaUseCase(repository),
            addNotaUseCase = AddNotaUseCase(repository),
            pegaNotaByIdUseCase = PegaNotaByIdUseCase(repository)
        )
    }


}