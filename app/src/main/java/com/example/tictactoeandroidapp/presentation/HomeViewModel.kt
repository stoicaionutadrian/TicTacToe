package com.example.tictactoeandroidapp.presentation

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tictactoeandroidapp.data.SystemInfoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val systemInfoRepository: SystemInfoRepository,
) : ViewModel() {
    private val _firstPlayerName: MutableLiveData<String> = MutableLiveData("Player 1")
    val firstPlayerName: LiveData<String> = _firstPlayerName

    private val _secondPlayerName: MutableLiveData<String> = MutableLiveData("Player 2")
    val secondPlayerName: LiveData<String> = _secondPlayerName

    @SuppressLint("CheckResult")
    fun getPlayersNames() {
        systemInfoRepository.getPlayerNames().subscribe {
            _firstPlayerName.value = it.first
            _secondPlayerName.value = it.second
        }
    }

    fun setFirstPlayerName(name: String) {
        systemInfoRepository.setPlayer1Name(name.ifEmpty { "Player 1" })
    }

    fun setSecondPlayerName(name: String) {
        systemInfoRepository.setPlayer2Name(name.ifEmpty { "Player 2" })
    }
}