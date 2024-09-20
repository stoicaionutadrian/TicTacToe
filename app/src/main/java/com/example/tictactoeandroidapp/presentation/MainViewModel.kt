package com.example.tictactoeandroidapp.presentation

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tictactoeandroidapp.data.GameRepository
import com.example.tictactoeandroidapp.data.SystemInfoRepository
import com.example.tictactoeandroidapp.ui.game.GameUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val systemInfoRepository: SystemInfoRepository,
    private val gameRepository: GameRepository,
) : ViewModel() {

    private val _gameUiState: MutableLiveData<GameUiState> = MutableLiveData(GameUiState())
    val gameUiState: LiveData<GameUiState> = _gameUiState
    private val playerNames = systemInfoRepository.getPlayerNames()

    @SuppressLint("CheckResult")
    fun processCommand(key: Int) {
        gameRepository.updateTableData(key).subscribe {
            _gameUiState.value = (_gameUiState.value?.copy(table = it.second))

            it.first?.let { winner ->
                systemInfoRepository.updateScore(winner == 1)
                systemInfoRepository.getScore().subscribe { score ->
                    _gameUiState.value = (
                            _gameUiState.value?.copy(
                                score = score,
                                winner = winner
                            ))
                }
            }
        }

    }

    fun restartGame() {
        _gameUiState.value = GameUiState(score = _gameUiState.value?.score ?: Pair(0, 0))
        gameRepository.restartGame()
    }

    fun handleBackClick() {
        systemInfoRepository.updateHistory()
    }
}