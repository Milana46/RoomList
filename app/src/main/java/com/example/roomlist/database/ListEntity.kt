package com.example.roomlist.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName="tasks")
data class ListEntity(

    @PrimaryKey(autoGenerate = true)
    val id:Int?=null,

    val task:String
)


