package com.example.tictactoeandroidapp.data

import io.reactivex.rxjava3.core.Observable

class GameRepositoryImpl : GameRepository {
    private var gameData: GameData = GameData()
    private val indexes = arrayListOf(0, 1, 2, 3, 4, 5, 6, 7, 8)

    override fun updateTableData(key: Int): Observable<Pair<Int?, ArrayList<String>>> {
        gameData.choicesTable[key + 1] = if (gameData.isFirstUser) "X" else "0"
        val winner = checkGameStatus(key + 1)

        gameData.isFirstUser = !gameData.isFirstUser
        return Observable.fromArray(indexes).flatMapIterable { it }
            .map { gameData.choicesTable[it + 1] ?: "" }.toList()
            .map { ArrayList(it) }
            .map {
                Pair(winner, it)
            }.toObservable()
    }

    private fun checkGameStatus(key: Int): Int? {
        if (gameData.choicesTable.size < 5) {
            return null
        }

        val keyCombinations = Combinations.gameCombinations[key] ?: return null

        for (combination in keyCombinations) {
            val previousItem = gameData.choicesTable[key]
            var areEqual = true
            for (item in combination) {
                if (previousItem == gameData.choicesTable[item]) {
                    continue
                }
                areEqual = false
                break
            }

            if (areEqual) {
                println("Player ${if (gameData.isFirstUser) "1" else "2"} wins!")
                gameData.gameInProgress = false
                return if (gameData.isFirstUser) {
                    1
                } else {
                    2
                }
            }
        }

        return null
    }

    override fun restartGame() {
        gameData.choicesTable.clear()
    }
}