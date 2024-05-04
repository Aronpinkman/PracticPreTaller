package com.chavezycanjura.taller1canjuraalejandro.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class AppScreens(val route: String, val label: String, val icon: ImageVector) {
    object Task : AppScreens("TaskScreen", "Tasks", Icons.Filled.Home)
    object CreateTask : AppScreens("CreateTaskScreen", "CreateTask", Icons.Filled.Email)
    object TaskDetails : AppScreens("TaskDetailsScreen", "TaskDetails", Icons.Filled.List)
}