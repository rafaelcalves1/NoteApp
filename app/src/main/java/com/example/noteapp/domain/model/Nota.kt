package com.example.noteapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.noteapp.R

@Entity
data class Nota(
    val titulo: String,
    val descricao: String,
    val datacriacao: Long,
    @PrimaryKey val idNota: Int
)