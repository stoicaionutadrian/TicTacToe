package com.example.tictactoeandroidapp.ui.game

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.tictactoeandroidapp.presentation.MainViewModel

@Composable
fun GameScreen(
    viewModel: MainViewModel,
    onItemClick: (position: Int) -> Unit,
    onRestartClick: () -> Unit,
    onBackClick: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        val gameUiState by viewModel.gameUiState.observeAsState()
        val winner = gameUiState?.winner
        GameTable(gameUiState?.table) {
            if (winner == null) onItemClick(it)
        }
        Text(text = if (winner == null) "" else "The winner is player $winner")

        val score = gameUiState?.score ?: Pair(0, 0)
        Text(text = "Current score: ${score.first} - ${score.second}")
        Button(onClick = { onRestartClick() },
            Modifier
                .align(CenterHorizontally)
                .padding(16.dp)) {
            Text(text = "Restart game")
        }
    }
    BackHandler {
        viewModel.handleBackClick()
        onBackClick()
    }
}

@Composable
private fun GameTable(gameBoard: ArrayList<String>?, onItemClick: (position: Int) -> Unit) {
    LazyVerticalGrid(
        modifier = Modifier.fillMaxWidth(),
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        content = {
            items(gameBoard?.size ?: 9) {
                val value = gameBoard?.get(it) ?: ""
                GameCell(text = value) {
                    onItemClick(it)
                }
            }
        })
}

@Composable
fun GameCell(text: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(100.dp)
            .clip(RoundedCornerShape(8.dp))
            .shadow(4.dp)
            .clickable {
                if (text.isEmpty()) {
                    onClick()
                }
            },
        contentAlignment = Alignment.Center

    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center
        )
    }
}