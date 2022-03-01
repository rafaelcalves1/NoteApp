package com.example.noteapp.domain.use_cases

data class NotasUseCases(
    val pegaNotasUseCase: PegaNotasUseCase,
    val deleteNotaUseCase: DeleteNotaUseCase,
    val addNotaUseCase: AddNotaUseCase,
    val pegaNotaByIdUseCase: PegaNotaByIdUseCase
)
