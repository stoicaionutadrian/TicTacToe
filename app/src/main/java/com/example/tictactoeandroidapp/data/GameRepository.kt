package com.example.tictactoeandroidapp.data

import io.reactivex.rxjava3.core.Observable

interface GameRepository {
    fun updateTableData(key: Int): Observable<Pair<Int?, ArrayList<String>>>
    fun restartGame()
}