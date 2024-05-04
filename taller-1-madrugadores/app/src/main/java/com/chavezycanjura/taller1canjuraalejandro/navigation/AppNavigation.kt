package com.chavezycanjura.taller1canjuraalejandro.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.chavezycanjura.taller1canjuraalejandro.screens.Task
import com.chavezycanjura.taller1canjuraalejandro.screens.TaskDetails
import com.chavezycanjura.taller1canjuraalejandro.screens.CreateTask
import com.chavezycanjura.taller1canjuraalejandro.viewmodel.TaskViewModel


@Composable
fun AppNavigation(viewmodel: TaskViewModel = viewModel()){

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