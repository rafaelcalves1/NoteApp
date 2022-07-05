package com.example.noteapp.di

import androidx.room.Room
import com.example.noteapp.data.data_source.NotaDataBase
import com.example.noteapp.data.data_source.NotaDataBase.Companion.DATABASE_NOME
import com.example.noteapp.data.repository.NotaRepositoryImpl
import com.example.noteapp.domain.repository.NotaRepository
import com.example.noteapp.domain.use_cases.*
import com.example.noteapp.presenter.viewmodel.NotasViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

object AppModule {

    val useCasesModule = module {
        factory { AddNotaUseCase(get()) }
        factory { DeleteNotaUseCase(get()) }
        factory { PegaNotasUseCase(get()) }
        factory { PegaNotaByIdUseCase(get()) }
        factory { NotasUseCases(get(), get(), get(), get()) }
    }

    val dataBaseModule = module {
        single {
            Room.databaseBuilder(
                androidApplication(),
                NotaDataBase::class.java,
                DATABASE_NOME
            ).build()
        }
    }

    val repositoryModule = module {
        singleOf(::NotaRepositoryImpl) {bind<NotaRepository>()}
    }

    val viewModelModule = module {
        viewModel { NotasViewModel(get()) }
    }

}