package com.example.noteapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Nota(
    val titulo: String,
    val descricao: String,
    val datacriacao: Long,
    val colorNota: Int,
    @PrimaryKey(autoGenerate = true) val idNota: Int = 0
)