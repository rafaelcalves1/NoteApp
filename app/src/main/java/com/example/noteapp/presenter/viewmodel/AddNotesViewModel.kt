package com.example.noteapp.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.domain.model.Nota
import com.example.noteapp.domain.use_cases.NotasUseCases
import kotlinx.coroutines.launch

class AddNotesViewModel(
    private val notasUseCases: NotasUseCases
) : ViewModel() {

    private val _addNoteSuccess = MutableLiveData<Long?>()
    val addNoteSuccess: LiveData<Long?>
        get() = _addNoteSuccess

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    fun addNotes(nota: Nota) {
        val title = nota.titulo
        val description = nota.descricao
        if (title.isNotBlank() && title.isNotEmpty() &&
            description.isNotBlank() && description.isNotEmpty()
        ) {
            viewModelScope.launch {
                _addNoteSuccess.value = notasUseCases.addNotaUseCase(nota)
            }
        } else {
            _error.value = "Invalid Note."
        }
    }

}