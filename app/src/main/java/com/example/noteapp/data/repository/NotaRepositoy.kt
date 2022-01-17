package com.example.noteapp.data.repository

import com.example.noteapp.data.model.Nota
import kotlinx.coroutines.flow.Flow

interface NotaRepositoy {

    fun pegaNotas(): Flow<List<Nota>>

    suspend fun pegaNotaById(id: Int): Nota?

    suspend fun adicionaNota(nota: Nota)

    suspend fun deletaNota(nota: Nota)
}