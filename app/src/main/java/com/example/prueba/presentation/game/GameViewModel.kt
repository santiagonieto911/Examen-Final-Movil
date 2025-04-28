package com.example.prueba.presentation.game

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prueba.domain.model.SudokuPuzzle
import com.example.prueba.domain.usecase.SudokuUseCases
import com.example.prueba.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val sudokuUseCases: SudokuUseCases
) : ViewModel() {

    private val _puzzleState = MutableStateFlow<Resource<SudokuPuzzle>>(Resource.Loading())
    val puzzleState = _puzzleState.asStateFlow()

    fun generatePuzzle(size: Int, difficulty: String) {
        viewModelScope.launch {
            _puzzleState.value = Resource.Loading()
            try {
                val (width, height) = when (size) {
                    4 -> 2 to 2
                    9 -> 3 to 3
                    else -> 3 to 3
                }
                val puzzle = sudokuUseCases.generateSudoku(width, height, difficulty)
                _puzzleState.value = Resource.Success(puzzle)
            } catch (e: Exception) {
                _puzzleState.value = Resource.Error(e.message ?: "Error al generar Sudoku")
            }
        }
    }
}
