package com.example.tictactoeandroidapp.ui.history

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tictactoeandroidapp.R
import com.example.tictactoeandroidapp.databinding.ItemHistoryBinding

class HistoryAdapter(private val list: ArrayList<String>) :
    RecyclerView.Adapter<HistoryItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_history, parent, false)
        return HistoryItemViewHolder(view, ItemHistoryBinding.bind(view))
    }

    override fun onBindViewHolder(holder: HistoryItemViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class HistoryItemViewHolder(itemView: View, private val binding: ItemHistoryBinding) :
    RecyclerView.ViewHolder(itemView) {
    fun bind(string: String) {
        binding.scoreText.text = string
    }

}