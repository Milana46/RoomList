package com.example.roomlist.userInterface

import android.app.Application
import com.example.roomlist.database.MainDb


class App : Application() {
    val database by lazy {
         MainDb.getDatabase(this)
    }

}