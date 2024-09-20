package com.example.tictactoeandroidapp.ui.game

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.tictactoeandroidapp.presentation.MainViewModel
import com.example.tictactoeandroidapp.ui.Screen

fun NavGraphBuilder.addGameTopLevel(
    navController: NavController
) {
    composable(Screen.Game.route) {
        val viewModel: MainViewModel = hiltViewModel()
        GameScreen(
            viewModel,
            onItemClick = { viewModel.processCommand(it) },
            onBackClick = {
                navController.popBackStack()
            },
            onRestartClick = {
                viewModel.restartGame()
            }
        )
    }
}
