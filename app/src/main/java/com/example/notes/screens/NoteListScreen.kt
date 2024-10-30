package com.example.notes.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.example.notes.data.Routes
import com.example.notes.data.Note
import com.example.notes.data.NoteStorage


@Composable
fun NoteListScreen(navController: NavController) {
    val noteList = NoteStorage.getAllNotes()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // If the noteList is empty, show text "No Notes"
        if (noteList.isEmpty()) {
            Text(
                text = "No Notes",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
                )
        } else {
            LazyColumn(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(noteList) { note ->
                    NoteItem(navController = navController, note = note)
                }
            }
        }
        ElevatedButton(onClick = {
            navController.navigate(Routes.NoteAddScreen)
        },
            modifier = Modifier
                .align(Alignment.BottomCenter)
        ) {
            Text(
                text = "New Note",
                textAlign = TextAlign.Center,
            )
        }
    }
}