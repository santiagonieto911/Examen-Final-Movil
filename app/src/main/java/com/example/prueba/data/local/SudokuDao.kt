package com.example.prueba.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.prueba.domain.model.SudokuPuzzleEntity

@Dao
interface SudokuDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePuzzle(puzzle: SudokuPuzzleEntity)

    @Query("SELECT * FROM sudoku_puzzle LIMIT 1")
    suspend fun loadPuzzle(): SudokuPuzzleEntity?
}
