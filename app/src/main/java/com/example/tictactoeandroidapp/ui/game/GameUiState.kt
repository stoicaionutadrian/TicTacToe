package com.example.tictactoeandroidapp.ui.game

data class GameUiState(
    var score: Pair<Int, Int> = Pair(0, 0),
    var table: ArrayList<String> = arrayListOf("","","","","","","","",""),
    var winner: Int? = null
)
