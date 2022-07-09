package com.example.noteapp.domain.use_cases

import com.example.noteapp.domain.model.Nota
import com.example.noteapp.domain.repository.NotaRepository

class AddNotaUseCase(
    private val notaRepository: NotaRepository
) {

    suspend operator fun invoke(nota: Nota): Long{
        return notaRepository.adicionaNota(nota)
    }
}