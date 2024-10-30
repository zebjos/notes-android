package com.example.notes.data

import java.util.UUID

data class Note (
    val id: String = UUID.randomUUID().toString(),
    var title: String,
    var content: String
)