package com.fcalderon.practicanavegacion.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fcalderon.practicanavegacion.screens.Home
import com.fcalderon.practicanavegacion.screens.Messages
import com.fcalderon.practicanavegacion.screens.Profile
import com.fcalderon.practicanavegacion.screens.Settings

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreens.Home.route) {

        composable(route = AppScreens.Home.route){
            Home(navController)
        }

        composable(route = AppScreens.Messages.route){
            Messages(navController)
        }

        composable(route = AppScreens.Profile.route){
            Profile(navController)
        }

        composable(route = AppScreens.Settings.route){
            Settings(navController)
        }

    }
}