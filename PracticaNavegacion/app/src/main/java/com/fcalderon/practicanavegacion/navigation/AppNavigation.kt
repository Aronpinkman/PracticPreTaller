package com.fcalderon.practicanavegacion.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fcalderon.practicanavegacion.data.MessageRepository
import com.fcalderon.practicanavegacion.screens.Home
import com.fcalderon.practicanavegacion.screens.Messages
import com.fcalderon.practicanavegacion.screens.Profile
import com.fcalderon.practicanavegacion.screens.Settings
import com.fcalderon.practicanavegacion.viewmodel.MessageViewModel
import com.fcalderon.practicanavegacion.viewmodel.MessageViewModelFactory

@Composable
fun AppNavigation() {

    val navController = rememberNavController()
    val messageRepository = MessageRepository() // Asume que tienes un constructor vacío o ajusta según tu implementación

    NavHost(navController = navController, startDestination = AppScreens.Home.route) {

        composable(route = AppScreens.Home.route){
            Home(navController)
        }

        composable(route = AppScreens.Messages.route) {
            val messageViewModel: MessageViewModel = viewModel(factory = MessageViewModelFactory(messageRepository))
            Messages(navController, messageViewModel)
        }
        composable(route = AppScreens.Profile.route){
            Profile(navController)
        }

        composable(route = AppScreens.Settings.route){
            Settings(navController)
        }

    }
}