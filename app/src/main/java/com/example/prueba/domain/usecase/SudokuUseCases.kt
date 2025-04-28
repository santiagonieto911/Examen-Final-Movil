package com.example.prueba.domain.usecase

data class SudokuUseCases(
    val generateSudoku: GenerateSudokuUseCase,
    val checkSudokuSolution: CheckSudokuSolutionUseCase,
    val saveSudoku: SaveSudokuUseCase,
    val loadSudoku: LoadSudokuUseCase
)
