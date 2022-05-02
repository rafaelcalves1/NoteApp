package com.example.noteapp.presenter.viewmodel

import androidx.lifecycle.ViewModel
import com.example.noteapp.domain.model.Nota
import com.example.noteapp.domain.repository.NotaRepository
import com.example.noteapp.domain.use_cases.NotasUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class NotasViewModel @Inject constructor(
    private val notasUseCases: NotasUseCases
) : ViewModel() {
a
a
}