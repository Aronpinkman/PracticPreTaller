package com.chavezycanjura.taller1canjuraalejandro.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.chavezycanjura.taller1canjuraalejandro.navigation.AppScreens

@Composable
fun BottomBarNavigation(navController: NavController) {

    val currentRoute = navController.currentDestination?.route ?: " "

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
    ) {
        NavigationBarItem(
            selected = currentRoute == AppScreens.Task.route,
            onClick = {
                navController.navigate(route = AppScreens.Task.route)
            },
            icon = {
                Icon(
                    imageVector = AppScreens.Task.icon,
                    contentDescription = "Home Icon",
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.size(36.dp)
                )
            },
            label = {
                Text(
                    text = AppScreens.Task.label,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        )
        NavigationBarItem(
            selected = currentRoute == AppScreens.CreateTask.route,
            onClick = {
                navController.navigate(route = AppScreens.CreateTask.route)
            },
            icon = {
                Icon(
                    imageVector = AppScreens.CreateTask.icon,
                    contentDescription = "Messages Icon",
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.size(36.dp)
                )
            },
            label = {
                Text(
                    text = AppScreens.CreateTask.label,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        )
        NavigationBarItem(
            selected = currentRoute == AppScreens.TaskDetails.route,
            onClick = {
                navController.navigate(route = AppScreens.TaskDetails.route)
            },
            icon = {
                Icon(
                    imageVector = AppScreens.TaskDetails.icon,
                    contentDescription = "List Icon",
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.size(36.dp)
                )
            },
            label = {
                Text(
                    text = AppScreens.TaskDetails.label,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        )

    }
}