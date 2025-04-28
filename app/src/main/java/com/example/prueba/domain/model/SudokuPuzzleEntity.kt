package com.example.prueba.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sudoku_puzzle")
data class SudokuPuzzleEntity(
    @PrimaryKey val id: Int = 0,
    val puzzle: String,
    val solution: String
)

