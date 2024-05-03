package com.fcalderon.practicanavegacion.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fcalderon.practicanavegacion.data.Message
import com.fcalderon.practicanavegacion.data.MessageRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

// En com.fcalderon.practicanavegacion.viewmodel
class MessageViewModel(private val repository: MessageRepository) : ViewModel() {

    private val _messages = MutableStateFlow<List<Message>>(emptyList())
    val messages: StateFlow<List<Message>> = _messages.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getMessages().collect { listOfMessages ->
                _messages.value = listOfMessages
            }
        }
    }

    fun saveMessage(title: String, description: String) {
        viewModelScope.launch {
            repository.saveMessage(Message(title, description))
        }
    }
}
