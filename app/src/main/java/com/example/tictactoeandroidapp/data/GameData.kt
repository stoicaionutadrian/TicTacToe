package com.example.tictactoeandroidapp.data

data class GameData(
    var isFirstUser: Boolean = true,
    var gameInProgress: Boolean = true,
    val choicesTable: HashMap<Int, String> = HashMap(9),
) {
    fun updateData(key: Int) {
        choicesTable[key] = if (isFirstUser) "X" else "0"
        checkGameStatus(key)

        isFirstUser = !isFirstUser
    }

    private fun checkGameStatus(key: Int) {
        if (choicesTable.size < 5) {
            return
        }

        val keyCombinations = Combinations.gameCombinations[key] ?: return

        for (combination in keyCombinations) {
            val previousItem = choicesTable[key]
            var areEqual = true
            for (item in combination) {
                if (previousItem == choicesTable[item]) {
                    continue
                }
                areEqual = false
                break
            }

            if (areEqual) {
                println("Player ${if (isFirstUser) "1" else "2"} wins!")
                gameInProgress = false
            }
        }
    }

}
