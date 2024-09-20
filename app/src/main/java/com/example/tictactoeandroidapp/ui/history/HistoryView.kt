package com.example.tictactoeandroidapp.ui.history


import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tictactoeandroidapp.R
import com.example.tictactoeandroidapp.presentation.HistoryViewModel


@SuppressLint("ViewConstructor")
class HistoryView(context: Context, viewModel: HistoryViewModel) : ConstraintLayout(context) {
    private var list = ArrayList<String>()

    init {
        val layoutInflater = LayoutInflater.from(context)

        layoutInflater.inflate(R.layout.fragment_history, this)
        viewModel.getHistoryList()
        list = viewModel.historyList.value ?: ArrayList()
    }


    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        val recyclerView = findViewById<RecyclerView>(R.id.games_scores_list)
        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = HistoryAdapter(list)
        recyclerView.adapter = adapter
    }
}