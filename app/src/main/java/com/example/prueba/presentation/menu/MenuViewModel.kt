package com.example.prueba.presentation.menu

import androidx.lifecycle.ViewModel
import com.example.prueba.domain.model.SudokuDifficulty
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MenuViewModel : ViewModel() {

    private val _selectedSize = MutableStateFlow(9)
    val selectedSize = _selectedSize.asStateFlow()

    private val _selectedDifficulty = MutableStateFlow(SudokuDifficulty.EASY)
    val selectedDifficulty = _selectedDifficulty.asStateFlow()

    fun setSize(size: Int) {
        _selectedSize.value = size
    }

    fun setDifficulty(difficulty: SudokuDifficulty) {
        _selectedDifficulty.value = difficulty
    }
}

