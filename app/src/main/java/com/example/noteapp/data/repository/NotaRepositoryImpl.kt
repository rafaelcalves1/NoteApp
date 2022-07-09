package com.example.noteapp.data.repository

import com.example.noteapp.data.data_source.NotaDao
import com.example.noteapp.domain.model.Nota
import com.example.noteapp.domain.repository.NotaRepository
import kotlinx.coroutines.flow.Flow

class NotaRepositoryImpl(private val dao: NotaDao) : NotaRepository {

    override fun pegaNotas(): Flow<List<Nota>> {
        return dao.pegaNotes()
    }

    override suspend fun pegaNotaById(id: Int): Nota? {
        return dao.pegaNoteById(id)
    }

    override suspend fun adicionaNota(nota: Nota): Long {
        return dao.adicionaNota(nota)
    }

    override suspend fun deletaNota(nota: Nota) {
        return dao.deletaNota(nota)
    }
}