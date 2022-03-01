package com.example.noteapp.domain.use_cases

import com.example.noteapp.domain.model.Nota
import com.example.noteapp.domain.repository.NotaRepository
import com.example.noteapp.domain.util.NotaOrder
import com.example.noteapp.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PegaNotasUseCase(
    private val repository: NotaRepository
) {

    operator fun invoke(
        notaOrder: NotaOrder = NotaOrder.Date(OrderType.Descending)
    ): Flow<List<Nota>>{
        return repository.pegaNotas().map { notas ->
            when(notaOrder.orderType) {
                is OrderType.Ascending -> {
                    when(notaOrder){
                        is NotaOrder.Date -> notas.sortedBy { it.titulo.lowercase() }
                        is NotaOrder.Title -> notas.sortedBy { it.datacriacao }
                        is NotaOrder.Color -> notas.sortedBy { it.colorNote }
                    }
                }
                is OrderType.Descending -> {
                    when(notaOrder){
                        is NotaOrder.Date -> notas.sortedByDescending { it.titulo.lowercase() }
                        is NotaOrder.Title -> notas.sortedByDescending { it.datacriacao }
                        is NotaOrder.Color -> notas.sortedByDescending { it.colorNote }
                    }
                }
            }
        }
    }
}