package com.example.noteapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.noteapp.R

@Entity
data class Nota(
    val titulo: String,
    val descricao: String,
    val datacriacao: Long,
    val colorNote: Int,
    @PrimaryKey val idNota: Int
){
    companion object{
        val noteColors = listOf( R.color.orange, R.color.yellow, R.color.violet, R.color.blue, R.color.pink)
    }
}
