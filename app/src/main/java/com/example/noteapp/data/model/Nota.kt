package com.example.noteapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Nota(
    val titulo: String,
    val descricao: String,
    val datacriacao: Long,
    @PrimaryKey val idNota: Int
)
