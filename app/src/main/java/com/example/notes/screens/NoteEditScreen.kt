package com.example.notes.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.notes.data.NoteStorage

@Composable
fun NoteEditScreen (navController: NavController, noteId: String?) {
    // Fetch the note based on the noteId
    val note = noteId?.let { NoteStorage.getNoteById(noteId) }

    val updatedTitle = remember { mutableStateOf(note?.title ?: "") }
    val updatedContent = remember { mutableStateOf(note?.content ?: "") }

    // UI for input fields, pre-filled with current note details
    if (updatedTitle != null && updatedContent != null) {
        Column (){
            TextField(
                value = updatedTitle.value,
                onValueChange = { updatedTitle.value = it },
                label = { Text("Title") },
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = updatedContent.value,
                onValueChange = { updatedContent.value = it },
                label = { Text("Content") },
                modifier = Modifier.fillMaxWidth()
            )
            Button(onClick = {
                if (noteId != null) {
                    NoteStorage.editNoteById(noteId, updatedTitle.value, updatedContent.value)
                }
                navController.popBackStack()
            }) {
                Text(
                    text = "Save"
                )
            }
        }
    }
}