package com.example.tictactoeandroidapp.data

import io.reactivex.rxjava3.core.Observable

class SystemInfoRepositoryImpl : SystemInfoRepository {
    private val systemInfo = SystemInfo()
    override fun setPlayer1Name(name: String) {
        systemInfo.player1Name = name
    }

    override fun setPlayer2Name(name: String) {
        systemInfo.player2Name = name
    }

    override fun updateScore(firstPlayerWon: Boolean) {
        if (firstPlayerWon) {
            systemInfo.player1Score++
        } else {
            systemInfo.player2Score++
        }
    }

    override fun getScore(): Observable<Pair<Int, Int>> {
        return Observable.just(Pair(systemInfo.player1Score, systemInfo.player2Score))
    }

    override fun getHistory(): Observable<ArrayList<String>> {
        return Observable.just(systemInfo.matchesHistory)
    }

    override fun updateHistory() {
        systemInfo.matchesHistory.add("${systemInfo.player1Score} - ${systemInfo.player2Score}")
        systemInfo.player1Score = 0
        systemInfo.player2Score = 0

    }

    override fun getPlayerNames(): Observable<Pair<String, String>> {
        return Observable.just(Pair(systemInfo.player1Name, systemInfo.player2Name))
    }
}