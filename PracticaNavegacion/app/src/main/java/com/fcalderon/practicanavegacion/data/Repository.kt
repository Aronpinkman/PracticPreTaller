package com.fcalderon.practicanavegacion.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

// En com.fcalderon.practicanavegacion.data.repository
class MessageRepository {

    // Simula una base de datos o almacenamiento local
    private val messages = mutableListOf<Message>()

    // Función para guardar mensajes
    suspend fun saveMessage(message: Message) = withContext(Dispatchers.Default) {
        messages.add(message)
    }

    // Función para obtener mensajes como Flow
    fun getMessages(): Flow<List<Message>> = flow {
        emit(messages.toList())
    }.flowOn(Dispatchers.Default)
}
