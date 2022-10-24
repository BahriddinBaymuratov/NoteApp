package com.example.noteapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.noteapp.R
import com.example.noteapp.database.NoteDataBase
import com.example.noteapp.databinding.ActivitySecondBinding
import com.example.noteapp.model.Note
import com.example.noteapp.utill.Time
import com.google.android.material.snackbar.Snackbar
import java.lang.Exception

class SecondActivity : AppCompatActivity() {
    private var forUpdate = false
    private lateinit var note: Note
    private lateinit var noteDataBase: NoteDataBase
    private val binding by lazy { ActivitySecondBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        noteDataBase = NoteDataBase(this)
        supportActionBar?.title = "Create note"

        try {
            note = intent.getParcelableExtra<Note>("note")!!
            supportActionBar?.title = note.title
            binding.desc.setText(note.description)
            forUpdate = true
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.save_menu, menu)
        return true
    }

    fun saveNote(menuItem: MenuItem?) {
        val title = binding.title.text.toString().trim()
        val desc = binding.desc.text.toString().trim()
        if (forUpdate) {
            val newNote = Note(note.id, title, desc, Time.timeStamp())
            noteDataBase.update(newNote)
            startActivity(Intent(this, MainActivity::class.java))
            finishAffinity()
        } else {
            if (title.isNotBlank() && desc.isNotBlank()) {
                val note = Note(title = title, description = desc, time = Time.timeStamp())
                noteDataBase.saveNote(note)
                startActivity(Intent(this, MainActivity::class.java))
                finishAffinity()
            } else {
                Snackbar.make(binding.root, "Enter some note!", Snackbar.LENGTH_LONG).show()
            }
        }
    }
}
















