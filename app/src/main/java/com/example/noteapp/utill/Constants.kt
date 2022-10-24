package com.example.noteapp.utill

import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

object Constants {
    const val DB_NAME = "Note.Db"
    const val DB_VERSION = 2

    const val TABLE_NAME = "Note_Table"
    const val ID = "id"
    const val TITLE = "title"
    const val TIME = "time"
    const val DESCRIPTION = "description"
}
object  Time{
    fun timeStamp(): String{
        val timeStamp = Timestamp(System.currentTimeMillis())
        val msh = SimpleDateFormat("EEE,d MMM yyy HH:mm a", Locale.getDefault())
        val time = msh.format(Date(timeStamp.time))
        return time.toString()
    }
}