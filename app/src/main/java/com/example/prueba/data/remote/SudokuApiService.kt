package com.example.prueba.data.remote

import com.example.prueba.domain.model.SudokuPuzzle
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface SudokuApiService {

    @GET("sudokugenerate")
    suspend fun generateSudoku(
        @Query("width") width: Int,
        @Query("height") height: Int,
        @Query("difficulty") difficulty: String,
        @Header("X-Api-Key") apiKey: String = com.example.prueba.util.Constants.API_KEY
    ): SudokuPuzzle
}
