package com.fcalderon.practicanavegacion.components

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
import com.fcalderon.practicanavegacion.navigation.AppScreens

@Composable
fun BottomBarNavigation(navController: NavController) {

    val currentRoute = navController.currentDestination?.route ?: " "

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
    ) {
        NavigationBarItem(
            selected = currentRoute == AppScreens.Home.route,
            onClick = {
                navController.navigate(route = AppScreens.Home.route)
            },
            icon = {
                Icon(
                    imageVector = AppScreens.Home.icon,
                    contentDescription = "Home Icon",
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.size(36.dp)
                )
            },
            label = {
                Text(
                    text = AppScreens.Home.label,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        )
        NavigationBarItem(
            selected = currentRoute == AppScreens.Messages.route,
            onClick = {
                navController.navigate(route = AppScreens.Messages.route)
            },
            icon = {
                Icon(
                    imageVector = AppScreens.Messages.icon,
                    contentDescription = "Messages Icon",
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.size(36.dp)
                )
            },
            label = {
                Text(
                    text = AppScreens.Messages.label,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        )
        NavigationBarItem(
            selected = currentRoute == AppScreens.Profile.route,
            onClick = {
                navController.navigate(route = AppScreens.Profile.route)
            },
            icon = {
                Icon(
                    imageVector = AppScreens.Profile.icon,
                    contentDescription = "List Icon",
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.size(36.dp)
                )
            },
            label = {
                Text(
                    text = AppScreens.Profile.label,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        )
        NavigationBarItem(
            selected = currentRoute == AppScreens.Settings.route,
            onClick = {
                navController.navigate(route = AppScreens.Settings.route)
            },
            icon = {
                Icon(
                    imageVector = AppScreens.Settings.icon,
                    contentDescription = "Settings Icon",
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.size(36.dp)
                )
            },
            label = {
                Text(
                    text = AppScreens.Settings.label,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        )
    }
}