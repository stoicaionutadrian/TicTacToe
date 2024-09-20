package com.example.tictactoeandroidapp.ui.history

import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.tictactoeandroidapp.presentation.HistoryViewModel
import com.example.tictactoeandroidapp.ui.Screen

fun NavGraphBuilder.addHistoryTopLevel(
    navController: NavController
) {
    composable(route = Screen.History.route) {
        val viewModel: HistoryViewModel = hiltViewModel()

        AndroidView(factory = {
            HistoryView(it, viewModel)
        })
    }
}