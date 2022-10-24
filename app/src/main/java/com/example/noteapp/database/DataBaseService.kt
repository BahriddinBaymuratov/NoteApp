package com.example.noteapp.database

import com.example.noteapp.model.Note

interface DataBaseService {

    // CRUD -> C = CREATE R = READ, U = UPDATE, D = DELETE
    fun saveNote(note: Note) // create
    fun update(note: Note) // update
    fun deleteNote(id: Int) // delete
    fun getAllNotes() :MutableList<Note> // read
    fun deleteAllNotes() // Delete All


}