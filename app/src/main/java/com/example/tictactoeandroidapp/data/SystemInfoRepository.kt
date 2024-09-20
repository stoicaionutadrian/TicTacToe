package com.example.tictactoeandroidapp.data

import io.reactivex.rxjava3.core.Observable

interface SystemInfoRepository {
    fun setPlayer1Name(name: String)
    fun setPlayer2Name(name: String)
    fun updateScore(firstPlayerWon: Boolean)
    fun getScore(): Observable<Pair<Int, Int>>
    fun getHistory(): Observable<ArrayList<String>>
    fun updateHistory()
    fun getPlayerNames(): Observable<Pair<String, String>>
}