package com.example.noteapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.noteapp.data.model.Nota
import com.example.noteapp.data.repository.NotaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val repository: NotaRepository
) : ViewModel() {

    fun pegaNotas(): Flow<List<Nota>> {
        return repository.pegaNotas()
    }


}