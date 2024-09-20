package com.example.tictactoeandroidapp.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tictactoeandroidapp.presentation.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    onGameClick: () -> Unit,
    onHistoryClick: () -> Unit,
    onAboutClick: () -> Unit
) {
    viewModel.getPlayersNames()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val focusManager = LocalFocusManager.current

        Text(text = "TicTacToe", fontSize = 24.sp, modifier = Modifier.padding(16.dp))
        Button(onClick = onGameClick, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Start game")
        }
        Button(onClick = onHistoryClick, modifier = Modifier.fillMaxWidth()) {
            Text(text = "View games History")
        }

        Button(
            onClick = onAboutClick, modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Text(text = "About")
        }

        val firstPlayerName = remember {
            mutableStateOf(TextFieldValue(viewModel.firstPlayerName.value ?: ""))
        }

        TextField(value = firstPlayerName.value, onValueChange = {
            firstPlayerName.value = it
        }, label = {
            Text(text = "First player name")
        },
            keyboardActions = KeyboardActions(onDone = {
                focusManager.clearFocus()
                viewModel.setFirstPlayerName(firstPlayerName.value.text)
            }), keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done)
        )

        val secondPlayerName = remember {
            mutableStateOf(TextFieldValue(viewModel.secondPlayerName.value ?: ""))
        }
        TextField(value = secondPlayerName.value, onValueChange = {
            secondPlayerName.value = it
        }, label = {
            Text(text = "Second player name")
        },
            keyboardActions = KeyboardActions(onDone = {
                focusManager.clearFocus()
                viewModel.setSecondPlayerName(secondPlayerName.value.text)
            }), keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done)
        )
    }
}