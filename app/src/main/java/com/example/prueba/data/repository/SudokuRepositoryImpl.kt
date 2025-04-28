package com.example.prueba.data.repository

import com.example.prueba.data.remote.SudokuApiService
import com.example.prueba.data.local.SudokuDao
import com.example.prueba.domain.model.SudokuPuzzle
import com.example.prueba.domain.model.SudokuPuzzleEntity
import com.example.prueba.domain.repository.SudokuRepository

class SudokuRepositoryImpl(
    private val api: SudokuApiService,
    private val dao: SudokuDao
) : SudokuRepository {
    override suspend fun generateSudoku(width: Int, height: Int, difficulty: String): SudokuPuzzle {
        return api.generateSudoku(width, height, difficulty)
    }

    override suspend fun savePuzzle(puzzle: SudokuPuzzleEntity) {
        dao.savePuzzle(puzzle)
    }

    override suspend fun loadPuzzle(): SudokuPuzzleEntity? {
        return dao.loadPuzzle()
    }
}
