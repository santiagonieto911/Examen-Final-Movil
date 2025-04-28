package com.example.prueba.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.prueba.domain.model.SudokuPuzzleEntity

@Database(entities = [SudokuPuzzleEntity::class], version = 1)
abstract class SudokuDatabase : RoomDatabase() {
    abstract fun sudokuDao(): SudokuDao
}
