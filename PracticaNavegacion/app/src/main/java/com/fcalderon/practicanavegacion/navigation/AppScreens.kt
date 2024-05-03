package com.fcalderon.practicanavegacion.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class AppScreens(val route: String, val label: String, val icon: ImageVector) {
    object Home : AppScreens("homeScreen", "Home", Icons.Filled.Home)
    object Messages : AppScreens("messagesScreen", "Messages", Icons.Filled.Email)
    object Profile : AppScreens("listScreen", "To do List", Icons.Filled.List)
    object Settings : AppScreens("settingsScreen", "Settings", Icons.Filled.Settings)
}