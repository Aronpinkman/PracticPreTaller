package com.fcalderon.practicanavegacion.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.fcalderon.practicanavegacion.components.BottomBarNavigation
import com.fcalderon.practicanavegacion.viewmodel.MessageViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Messages(navController: NavController, viewModel: MessageViewModel) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    val scaffoldState = rememberScaffoldState()
    val successMessage by viewModel.message.collectAsState()
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Messages") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        bottomBar = {
            BottomBarNavigation(navController)
        }
    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Título") },
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            )
            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Descripción") },
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            )
            Button(
                onClick = { viewModel.saveMessage(title, description) },
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Guardar", fontSize = 18.sp)
            }
        }
    }
    LaunchedEffect(successMessage) {
        if (successMessage.isNotEmpty()) {
            scaffoldState.snackbarHostState.showSnackbar(successMessage)
        }
    }
}