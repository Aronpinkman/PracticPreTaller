package com.fcalderon.practicanavegacion.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

class MessageRepository {
    private val messages = mutableListOf<Message>()
    private val _saveSuccess = MutableSharedFlow<String>()
    val saveSuccess = _saveSuccess.asSharedFlow()

    suspend fun saveMessage(message: Message) = withContext(Dispatchers.Default) {
        messages.add(message)
        _saveSuccess.emit("Los datos se han guardado con éxito")  // Emitir mensaje de éxito
    }

    fun getMessages(): Flow<List<Message>> = flow {
        emit(messages.toList())
    }.flowOn(Dispatchers.Default)
}
