package com.example.tictactoeandroidapp.ui

sealed class Screen(val route: String) {
    object Home : Screen(route = "home")
    object History : Screen(route = "history")
    object About : Screen(route = "about")
    object Game : Screen(route = "game")

}
