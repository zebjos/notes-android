package com.example.notes.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.notes.data.NoteStorage
import com.example.notes.data.Routes

@Composable
fun NoteDetailScreen(navController: NavController, noteId: String?) {
    // Fetch the note based on the noteId
    val note = noteId?.let { NoteStorage.getNoteById(noteId) }

    Column (
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Display the note details
        if (note != null) {
            Text(
                text = note.title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = note.content,
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            FilledTonalButton(onClick = {
                navController.navigate("${Routes.NoteEditScreen}/${note.id}")
            }) {
                Text(
                    text = "Edit Note"
                )
            }
            OutlinedButton(onClick = {
                NoteStorage.deleteNoteById(noteId)
                navController.navigate(Routes.NoteListScreen)
            },
                ) {
                Text(
                    text = "Delete",
                    color = Color.Red
                )
            }
        }
    }
}