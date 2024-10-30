package com.example.notes.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.notes.data.Routes
import com.example.notes.data.Note

@Composable
fun NoteItem(navController: NavController, note: Note) { // Take a single instance of the note class
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { navController.navigate("${Routes.NoteDetailScreen}/${note.id}") }
            .padding(all = 8.dp)
    ) {
        Text(
            text = note.title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }
}