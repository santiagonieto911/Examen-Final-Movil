package com.example.prueba.domain.usecase

import com.example.prueba.domain.model.SudokuPuzzle
import com.example.prueba.domain.repository.SudokuRepository

class GenerateSudokuUseCase(
    private val repository: SudokuRepository
) {
    suspend operator fun invoke(width: Int, height: Int, difficulty: String): SudokuPuzzle {
        return repository.generateSudoku(width, height, difficulty)
    }
}
