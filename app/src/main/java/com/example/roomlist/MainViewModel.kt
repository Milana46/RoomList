package com.example.roomlist

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.roomlist.database.MainDb
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import com.example.roomlist.database.ListEntity
import com.example.roomlist.userInterface.App
import kotlinx.coroutines.launch

class MainViewModel(val db: MainDb) : ViewModel() {
    val itemsList = db.dao().getAllTasks()
    val newText = mutableStateOf("")

    var taskEntity: ListEntity? = null
    fun insertItem() = viewModelScope.launch {
        val taskItem = taskEntity?.copy(task = newText.value) ?: ListEntity(task = newText.value)
        db.dao().insertTasks(taskItem)
        taskEntity=null
        newText.value=""

    }


    companion object {
        val factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {

                val db = (checkNotNull(extras[APPLICATION_KEY]) as App).database
                return MainViewModel(db) as T
            }
        }
    }


}