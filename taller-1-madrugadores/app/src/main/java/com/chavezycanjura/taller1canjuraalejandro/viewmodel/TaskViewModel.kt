package com.chavezycanjura.taller1canjuraalejandro.viewmodel

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chavezycanjura.taller1canjuraalejandro.models.Task
import kotlinx.coroutines.launch

class TaskViewModel : ViewModel() {
    private val _datos = mutableStateOf<List<Task>>(emptyList())
    val datos: List<Task> get() = _datos.value

    fun agregardatos (file: Task)
    {
        _datos.value +=file
    }
    fun getTask(indice : Int):Task {
        return datos[indice]
    }

    fun flujoindice(indice: Int, item: Task){
        if (indice in datos.indices){
            _datos.value = datos.toMutableList().apply {
                set(indice,item )
            }
        }
    }
}