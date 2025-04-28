package com.example.prueba.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.prueba.presentation.game.GameScreen
import com.example.prueba.presentation.game.GameViewModel
import com.example.prueba.presentation.menu.MenuScreen
import com.example.prueba.presentation.menu.MenuViewModel

@Composable
fun AppNavigation(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = "menu") {
        composable("menu") {
            val menuViewModel: MenuViewModel = hiltViewModel()
            MenuScreen(navController, menuViewModel)
        }
        composable("game/{size}/{difficulty}") { backStackEntry ->
            val size = backStackEntry.arguments?.getString("size")?.toIntOrNull() ?: 9
            val difficulty = backStackEntry.arguments?.getString("difficulty") ?: "easy"
            val gameViewModel: GameViewModel = hiltViewModel()
            GameScreen(size, difficulty, gameViewModel)
        }
    }
}


