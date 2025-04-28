package com.example.prueba.domain.repository

import com.example.prueba.domain.model.SudokuPuzzle
import com.example.prueba.domain.model.SudokuPuzzleEntity

interface SudokuRepository {
    suspend fun generateSudoku(width: Int, height: Int, difficulty: String): SudokuPuzzle
    suspend fun savePuzzle(puzzle: SudokuPuzzleEntity)
    suspend fun loadPuzzle(): SudokuPuzzleEntity?
}
