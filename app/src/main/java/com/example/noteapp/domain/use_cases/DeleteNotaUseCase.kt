package com.example.noteapp.domain.use_cases

import com.example.noteapp.domain.model.Nota
import com.example.noteapp.domain.repository.NotaRepository

class DeleteNotaUseCase(
    private val notaRepository: NotaRepository
) {

    suspend operator fun invoke(nota: Nota){
        notaRepository.deletaNota(nota)
    }
}