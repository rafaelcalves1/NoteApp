package com.example.noteapp.domain.use_cases

import com.example.noteapp.domain.repository.NotaRepository

class PegaNotaByIdUseCase(
    private val notaRepository: NotaRepository
) {

    suspend operator fun invoke(id: Int){
        notaRepository.pegaNotaById(id)
    }
}