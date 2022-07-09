package com.example.noteapp.domain.repository

import com.example.noteapp.domain.model.Nota
import kotlinx.coroutines.flow.Flow

interface NotaRepository {

    fun pegaNotas(): Flow<List<Nota>>

    suspend fun pegaNotaById(id: Int): Nota?

    suspend fun adicionaNota(nota: Nota) : Long

    suspend fun deletaNota(nota: Nota)
}