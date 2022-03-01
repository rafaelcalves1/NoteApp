package com.example.noteapp.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.noteapp.domain.model.Nota
import kotlinx.coroutines.flow.Flow

@Dao
interface NotaDao {

    @Query("SELECT * FROM nota")
    fun pegaNotes(): Flow<List<Nota>>

    @Query("SELECT * FROM nota WHERE idNota = :id")
    suspend fun pegaNoteById(id: Int): Nota?

    @Insert(onConflict = REPLACE)
    suspend fun adicionaNota(nota: Nota)

    @Delete
    suspend fun deletaNota(nota: Nota)
}