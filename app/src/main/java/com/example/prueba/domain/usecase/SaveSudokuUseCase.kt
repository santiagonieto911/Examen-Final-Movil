package com.example.prueba.domain.usecase

import com.example.prueba.domain.model.SudokuPuzzleEntity
import com.example.prueba.domain.repository.SudokuRepository

class SaveSudokuUseCase(
    private val repository: SudokuRepository
) {
    suspend operator fun invoke(puzzle: SudokuPuzzleEntity) {
        repository.savePuzzle(puzzle)
    }
}
