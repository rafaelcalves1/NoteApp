package com.example.noteapp.data.repository

import com.example.noteapp.data.data_source.NotaDao
import com.example.noteapp.data.model.Nota
import kotlinx.coroutines.flow.Flow

class NotaRepositoyImpl(private val dao: NotaDao) : NotaRepositoy {

    override fun pegaNotas(): Flow<List<Nota>> {
        return dao.pegaNotes()
    }

    override suspend fun pegaNotaById(id: Int): Nota? {
        return dao.pegaNoteById(id)
    }

    override suspend fun adicionaNota(nota: Nota) {
        return dao.adicionaNota(nota)
    }

    override suspend fun deletaNota(nota: Nota) {
        return dao.deletaNota(nota)
    }
}