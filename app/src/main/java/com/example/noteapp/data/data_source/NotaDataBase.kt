package com.example.noteapp.data.data_source

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.noteapp.domain.model.Nota

@Database(
    entities = [Nota::class],
    version = 1,
    autoMigrations = [
        AutoMigration(
            from = 1,
            to = 2
        )
    ]
)
abstract class NotaDataBase : RoomDatabase() {

    abstract val notaDao: NotaDao

    companion object{
        const val DATABASE_NOME = "nota_db"
    }
}