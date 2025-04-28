package com.example.prueba.domain.usecase

import com.example.prueba.domain.model.SudokuPuzzleEntity
import com.example.prueba.domain.repository.SudokuRepository

class LoadSudokuUseCase(
    private val repository: SudokuRepository
) {
    suspend operator fun invoke(): SudokuPuzzleEntity? {
        return repository.loadPuzzle()
    }
}
