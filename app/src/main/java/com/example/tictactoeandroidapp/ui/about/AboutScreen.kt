package com.example.tictactoeandroidapp.ui.about

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun AboutScreen(appVersion: String) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "About",
            style = TextStyle(fontSize = 24.sp, textAlign = TextAlign.Center),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
        )
        Text(modifier = Modifier.padding(4.dp), text = "App version: $appVersion")
        Text(modifier = Modifier.padding(4.dp), text = "Developer name: Ionut Stoica")
    }
}