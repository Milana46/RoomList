package com.example.roomlist.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface DaoList {

    //и добавление и четкое исправление(update)!!!
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTasks(task: ListEntity)

    @Delete
    suspend fun deleteTasks(task: ListEntity)


    @Query("SELECT * FROM tasks")
    fun getAllTasks(): Flow<List<ListEntity>>

}