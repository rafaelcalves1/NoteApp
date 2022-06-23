package com.example.noteapp.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.domain.model.Nota
import com.example.noteapp.domain.repository.NotaRepository
import com.example.noteapp.domain.use_cases.NotasUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotasViewModel @Inject constructor(
    private val notasUseCases: NotasUseCases
) : ViewModel() {

    private val _notas =  MutableLiveData<List<Nota>>()
    val listNotas: LiveData<List<Nota>> = _notas

    fun getNotes(){
        viewModelScope.launch {
            notasUseCases.pegaNotasUseCase.invoke().collect {
                _notas.value = it
            }
        }
    }

}