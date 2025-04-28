package com.example.prueba.presentation.game

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.prueba.util.Resource

@Composable
fun GameScreen(size: Int, difficulty: String, viewModel: GameViewModel) {
    val puzzleState by viewModel.puzzleState.collectAsState()
    var showSolution by remember { mutableStateOf(false) }

    LaunchedEffect(size, difficulty) {
        viewModel.generatePuzzle(size, difficulty)
    }

    when (puzzleState) {
        is Resource.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        is Resource.Success -> {
            val data = (puzzleState as Resource.Success).data
            val puzzle = if (showSolution) data?.solution else data?.puzzle

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (puzzle != null) {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(size),
                        contentPadding = PaddingValues(8.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1f)
                    ) {
                        items(puzzle.flatten()) { number ->
                            SudokuCell(number ?: 0)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(onClick = {
                        showSolution = false
                        viewModel.generatePuzzle(size, difficulty)
                    }) {
                        Text("Nuevo Sudoku")
                    }

                    Button(onClick = {
                        showSolution = true
                    }) {
                        Text("Ver Sudoku Correcto")
                    }
                }
            }
        }
        is Resource.Error -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Error: ${(puzzleState as Resource.Error).message}")
            }
        }
    }
}

@Composable
fun SudokuCell(number: Int) {
    Card(
        modifier = Modifier
            .padding(2.dp)
            .aspectRatio(1f),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = if (number == 0) "" else number.toString())
        }
    }
}
