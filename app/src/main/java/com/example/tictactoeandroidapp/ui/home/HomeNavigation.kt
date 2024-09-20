package com.example.tictactoeandroidapp.ui.home

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.tictactoeandroidapp.presentation.HomeViewModel
import com.example.tictactoeandroidapp.ui.Screen

fun NavGraphBuilder.addHomeTopLevel(
    navController: NavController
) {
    composable(route = Screen.Home.route) {
        val viewModel: HomeViewModel = hiltViewModel()
        HomeScreen(viewModel, {
            navController.navigate(Screen.Game.route)
        }, {
            navController.navigate(Screen.History.route)
        }) {
            navController.navigate(Screen.About.route)
        }
    }
}