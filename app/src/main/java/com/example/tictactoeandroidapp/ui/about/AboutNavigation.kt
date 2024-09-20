package com.example.tictactoeandroidapp.ui.about

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.tictactoeandroidapp.BuildConfig
import com.example.tictactoeandroidapp.ui.Screen

fun NavGraphBuilder.addAboutTopLevel(
    navController: NavController
) {
    composable(route = Screen.About.route) {
        AboutScreen(
            BuildConfig.VERSION_NAME
        )
    }
}