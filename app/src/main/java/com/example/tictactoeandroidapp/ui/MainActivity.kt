package com.example.tictactoeandroidapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.tictactoeandroidapp.ui.about.addAboutTopLevel
import com.example.tictactoeandroidapp.ui.game.addGameTopLevel
import com.example.tictactoeandroidapp.ui.history.addHistoryTopLevel
import com.example.tictactoeandroidapp.ui.home.addHomeTopLevel
import com.example.tictactoeandroidapp.ui.theme.TicTacToeAndroidAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            TicTacToeAndroidAppTheme {
                NavHost(navController = navController, startDestination = Screen.Home.route) {
                    addHomeTopLevel(navController)
                    addGameTopLevel(navController)
                    addAboutTopLevel(navController)
                    addHistoryTopLevel(navController)
                }
            }
        }
    }
}