package com.fcalderon.practicanavegacion.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.fcalderon.practicanavegacion.components.BottomBarNavigation

data class Task(
    var title: String,
    var description: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavController) {
    var tasks = remember { mutableStateListOf(
        Task("Corto Calculo 2", "Corto 2 de cálculo 2, el cual será de integrales"),
        Task("Taller 1 PDM", "Estudiando LazyColumn, barnavigation"),
        Task("Corto WEB", "JAVASCRIPT"),
        Task("Corto Evaluado", "El cual será de integrales"),
        Task("Corto Calculo 2", "Corto 2 de cálculo 2, el cual será de integrales"),
        Task("Taller 1 PDM", "Estudiando LazyColumn, barnavigation"),
        Task("Corto WEB", "JAVASCRIPT"),
        Task("Corto Evaluado", "El cual será de integrales"),
        Task("Corto Calculo 2", "Corto 2 de cálculo 2, el cual será de integrales"),
        Task("Taller 1 PDM", "Estudiando LazyColumn, barnavigation"),
        Task("Corto WEB", "JAVASCRIPT"),
        Task("Corto Evaluado", "El cual será de integrales"),
        Task("Corto Calculo 2", "Corto 2 de cálculo 2, el cual será de integrales"),
        Task("Taller 1 PDM", "Estudiando LazyColumn, barnavigation"),
        Task("Corto WEB", "JAVASCRIPT"),
        Task("Corto Evaluado", "El cual será de integrales"),
        Task("Corto Calculo 2", "Corto 2 de cálculo 2, el cual será de integrales"),
        Task("Taller 1 PDM", "Estudiando LazyColumn, barnavigation"),
        Task("Corto WEB", "JAVASCRIPT"),
        Task("Corto Evaluado", "El cual será de integrales"),
        Task("Corto Calculo 2", "Corto 2 de cálculo 2, el cual será de integrales"),
        Task("Taller 1 PDM", "Estudiando LazyColumn, barnavigation"),
        Task("Corto WEB", "JAVASCRIPT"),
        Task("Corto Evaluado", "El cual será de integrales"),
        // Agrega más tareas aquí según sea necesario
    )}

    var taskToEdit by remember { mutableStateOf<Task?>(null) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Home") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
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
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .fillMaxWidth()
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize().fillMaxWidth(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ) {
                items(tasks) { task ->
                    TaskItemView(task, onTaskClick = { taskToEdit = it })
                }
            }
        }
    }

    taskToEdit?.let {
        EditTaskDialog(task = it, onDismiss = { taskToEdit = null })
    }
}

@Composable
fun TaskItemView(task: Task, onTaskClick: (Task) -> Unit) {
    Column(modifier = Modifier
        .padding(16.dp)
        .clickable { onTaskClick(task) }) {
        Text(text = task.title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Text(text = task.description, fontSize = 14.sp)
    }
}

@Composable
fun EditTaskDialog(task: Task, onDismiss: () -> Unit) {
    var title by remember { mutableStateOf(task.title) }
    var description by remember { mutableStateOf(task.description) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Editar Tarea") },
        text = {
            Column {
                TextField(value = title, onValueChange = { title = it }, label = { Text("Título") })
                TextField(value = description, onValueChange = { description = it }, label = { Text("Descripción") })
            }
        },
        confirmButton = {
            Button(onClick = {
                task.title = title
                task.description = description
                onDismiss()
            }) {
                Text("Guardar")
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text("Cancelar")
            }
        }
    )
}
