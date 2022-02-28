package com.example.noteapp.presenter.viewmodel

import androidx.lifecycle.ViewModel
import com.example.noteapp.data.model.Nota
import com.example.noteapp.data.repository.NotaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val repository: NotaRepository
) : ViewModel() {

    fun pegaNotas(): Flow<List<Nota>> {
        return repository.pegaNotas()
    }


}