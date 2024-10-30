package com.example.notes.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun TestScreen(){
    var count by remember { mutableStateOf(0) }

    var change by remember { mutableStateOf("string")}

    Column (
        Modifier
            .fillMaxWidth()
            .background(Color.White)
    ){
        Text(text = "$count")
        Button(onClick = { count++ }) {
            Text(text = "add 1 to counter :D")
        }
        Text(text = "$change")
        ElevatedButton(onClick = { change+="abc"}) {
            Text(text = "oeoeoe")
        }
    }
}