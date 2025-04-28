package com.example.prueba.domain.usecase

class CheckSudokuSolutionUseCase {
    fun isSolutionCorrect(puzzle: List<List<Int>>, solution: List<List<Int>>): Boolean {
        return puzzle == solution
    }
}
