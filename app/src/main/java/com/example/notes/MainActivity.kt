package com.example.notes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notes.data.Note
import com.example.notes.data.Routes
import com.example.notes.screens.NoteAddScreen
import com.example.notes.screens.NoteDetailScreen
import com.example.notes.screens.NoteEditScreen
import com.example.notes.screens.NoteListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            val sampleNotes = listOf(
                Note(title = "Sample Note 1", content = "This is the first note."),
                Note(title = "Sample Note 2", content = "This is the second note.")
            )

            NavHost(navController = navController, startDestination = Routes.NoteListScreen, builder = {

                composable(Routes.NoteListScreen,){
                    NoteListScreen(navController)
                }

                composable(Routes.NoteAddScreen,){
                    NoteAddScreen(navController)
                }

                composable("${Routes.NoteDetailScreen}/{noteId}") { backStackEntry ->
                    // Retrieve the noteId from the arguments and pass it to NoteDetailScreen
                    val noteId = backStackEntry.arguments?.getString("noteId")
                    NoteDetailScreen(navController = navController, noteId = noteId)
                }

                composable("${Routes.NoteEditScreen}/{noteId}"){ backStackEntry ->

                    val noteId = backStackEntry.arguments?.getString("noteId")
                    NoteEditScreen(navController, noteId = noteId)
                }
            })
        }
    }
}