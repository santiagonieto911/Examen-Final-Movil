package com.example.prueba.presentation.menu

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.prueba.domain.model.SudokuDifficulty

@Composable
fun MenuScreen(navController: NavController, viewModel: MenuViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Tamaño del Sudoku")
        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { viewModel.setSize(4) }) {
            Text("4x4")
        }
        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { viewModel.setSize(9) }) {
            Text("9x9")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Dificultad")
        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { viewModel.setDifficulty(SudokuDifficulty.EASY) }) {
            Text("Fácil")
        }
        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { viewModel.setDifficulty(SudokuDifficulty.MEDIUM) }) {
            Text("Medio")
        }
        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { viewModel.setDifficulty(SudokuDifficulty.HARD) }) {
            Text("Difícil")
        }
        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = {
            val size = viewModel.selectedSize.value
            val difficulty = viewModel.selectedDifficulty.value.value
            navController.navigate("game/$size/$difficulty")
        }) {
            Text("Empezar Sudoku")
        }
    }
}
