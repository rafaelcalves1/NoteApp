package com.example.noteapp.domain.use_cases

import dagger.Provides
import javax.inject.Inject

data class NotasUseCases(
    val pegaNotasUseCase: PegaNotasUseCase,
    val deleteNotaUseCase: DeleteNotaUseCase,
    val addNotaUseCase: AddNotaUseCase,
    val pegaNotaByIdUseCase: PegaNotaByIdUseCase
)
