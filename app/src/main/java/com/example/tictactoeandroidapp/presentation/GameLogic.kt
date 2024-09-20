package com.example.tictactoeandroidapp.presentation

import com.example.tictactoeandroidapp.data.GameData

class GameLogic {
    private val gameData = GameData()


    fun validateCommand(command: String): Boolean {
        try {
            val key = (command[1] - 1).digitToInt() * 3 + command[0].hashCode() - 'a'.hashCode() + 1
            if ((key > 9 || key < 0) || !gameData.choicesTable[key].isNullOrEmpty()) {
                println("Wrong command. Please try again!")
                return false
            }

            updateTable(key)

        } catch (e: Exception) {
            return false
        }
        return true
    }

    private fun updateTable(key: Int) {
        gameData.updateData(key)
    }

    fun getValueForPosition(line: Int, column: Int): String? {
        return gameData.choicesTable[(line - 1) * 3 + column]
    }

    fun isGameInProgress() = gameData.gameInProgress

}