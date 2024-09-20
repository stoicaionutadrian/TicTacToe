package com.example.tictactoeandroidapp.data

data class SystemInfo(
    var player1Name: String = "",
    var player2Name: String = "",
    var player1Score: Int = 0,
    var player2Score: Int = 0,
    val matchesHistory: ArrayList<String> = ArrayList()
)
