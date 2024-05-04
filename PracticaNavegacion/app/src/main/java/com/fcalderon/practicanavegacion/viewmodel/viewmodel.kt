package com.fcalderon.practicanavegacion.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fcalderon.practicanavegacion.data.Message
import com.fcalderon.practicanavegacion.data.MessageRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MessageViewModel(private val repository: MessageRepository) : ViewModel() {
    private val _message = MutableStateFlow("")
    val message: StateFlow<String> = _message.asStateFlow()

    fun saveMessage(title: String, description: String) {
        viewModelScope.launch {
            repository.saveMessage(Message(title, description))
        }
        viewModelScope.launch {
            repository.saveSuccess.collect {
                _message.value = it
            }
        }
    }
}
