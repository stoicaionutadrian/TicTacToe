package com.example.tictactoeandroidapp.presentation

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tictactoeandroidapp.data.SystemInfoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val systemInfoRepository: SystemInfoRepository
) : ViewModel() {

    private val _historyList: MutableLiveData<ArrayList<String>> = MutableLiveData(ArrayList())
    val historyList: LiveData<ArrayList<String>> = _historyList

    @SuppressLint("CheckResult")
    fun getHistoryList() {
        systemInfoRepository.getHistory().subscribe {
            _historyList.value = it
        }
    }
}