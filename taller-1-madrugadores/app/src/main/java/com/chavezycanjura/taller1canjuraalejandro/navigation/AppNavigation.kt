package com.chavezycanjura.taller1canjuraalejandro.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.chavezycanjura.taller1canjuraalejandro.screens.Task
import com.chavezycanjura.taller1canjuraalejandro.screens.TaskDetails
import com.chavezycanjura.taller1canjuraalejandro.screens.CreateTask


@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreens.Task.route) {

        composable(route = AppScreens.CreateTask.route){
            CreateTask(navController)
        }

        composable(route = AppScreens.Task.route){
            Task(navController)
        }

        composable(route = AppScreens.TaskDetails.route){
            TaskDetails(navController)
        }


    }
}