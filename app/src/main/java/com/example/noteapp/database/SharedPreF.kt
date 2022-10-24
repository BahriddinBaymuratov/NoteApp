package com.example.noteapp.database

import android.content.Context
import android.content.SharedPreferences

class SharedPreF(context: Context) {
    private val mySharedPref: SharedPreferences =
        context.getSharedPreferences("My_Pref",Context.MODE_PRIVATE)

    fun saveManager(save: Boolean){
        val edit = mySharedPref.edit()
        edit.putBoolean("save", save)
        edit.apply()
    }
    fun getManager(): Boolean{
        return mySharedPref.getBoolean("save", false)
    }
}