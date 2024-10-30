package com.example.notes.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.notes.data.Note
import com.example.notes.data.NoteStorage
import com.example.notes.data.NoteStorage.addNote
import com.example.notes.data.Routes
import java.util.UUID

@Composable
fun NoteAddScreen(navController: NavController){
    var title by remember  { mutableStateOf("") } // Here "remember" is used to allow it to change dynamically in the view
    var content by remember { mutableStateOf("") }

    var validationError by remember { mutableStateOf("")}

    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        TextField(
            value = title,
            onValueChange = {title = it},
            label = { Text("Title")},
        )
        TextField(
            value = content,
            onValueChange = {content = it},
            label = { Text("Content")},
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text="$validationError",
            color = Color.Red
        )
        ElevatedButton(onClick = {
            if (title.length in 3..20 && content.length in 4..100) {
                val note = Note(id = UUID.randomUUID().toString(),title, content)
                NoteStorage.addNote(note)
                navController.navigate(Routes.NoteListScreen)
            } else {
                validationError = "Make sure length of the title is no less than 3 and no more than 20," +
                        "content no less than 4 and no more than 100"
            }
        }) {
            Text(text = "Add Note")
        }
    }
}