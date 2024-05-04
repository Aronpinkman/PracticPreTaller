package com.chavezycanjura.taller1canjuraalejandro.models
data class Task(
        val title: String,
        val description: String,
        val date: Long,
        val icon: String,
        val category: String,
        val isCompleted: Boolean = false
    )
