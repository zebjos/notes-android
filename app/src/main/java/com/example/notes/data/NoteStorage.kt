package com.example.notes.data

object NoteStorage {
    private val notes = mutableListOf<Note>()

    // Function to add note
    fun addNote(note: Note) {
        notes.add(note)
    }

    // Function to delete note by ID
    fun deleteNoteById(noteId: String) {
        notes.removeAll{
            it.id == noteId
        }
    }

    fun editNoteById(noteId: String, newTitle: String, newContent: String) {
        val note = notes.find { it.id == noteId }
        note?.let {
            it.title = newTitle.toString()
            it.content = newContent.toString()
        }
    }

    // Function to retrieve a note by ID
    fun getNoteById(noteId: String): Note? {
        return notes.find { it.id == noteId }
    }

    // Function to get all notes
    fun getAllNotes(): List <Note> {
        return notes
    }
}