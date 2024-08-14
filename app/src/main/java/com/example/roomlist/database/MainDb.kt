package com.example.roomlist.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room


import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [ListEntity::class]
)
abstract class MainDb : RoomDatabase() {

    abstract fun dao(): DaoList

    companion object {
        @Volatile
        private var INSTANCE: MainDb? = null

        fun getDatabase(context: Context): MainDb {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MainDb::class.java,
                    "tasks"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
