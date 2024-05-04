package com.chavezycanjura.taller1canjuraalejandro.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.chavezycanjura.taller1canjuraalejandro.components.BottomBarNavigation
import java.time.Instant
import java.time.ZoneId

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Task(navController: NavController, viewModel: ViewModel = viewModel()) {

    val dateState = rememberDatePickerState()
    var dateSelected = dateState.selectedDateMillis
    var toDoItemTitle by remember { mutableStateOf(" ") }
    var toDoItemBody by remember { mutableStateOf(" ") }
    var showDatePicker by remember { mutableStateOf(false) }
    var expanded by remember { mutableStateOf(false) }
    var expanded2 by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("") }
    var selectedText2 by remember { mutableStateOf("") }

    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = {
                Text(text = "Agregar Tareas")
            }, colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = MaterialTheme.colorScheme.onPrimary
            )
        )
    }, floatingActionButton = {

    }, snackbarHost = {

    }, bottomBar = {
        BottomBarNavigation(navController)
    }) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                Text(text = "Add Item", fontSize = 30.sp, fontWeight = FontWeight.ExtraBold)
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(18.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "Titulo de la tarea:",
                            modifier = Modifier.fillMaxWidth(),
                            fontWeight = FontWeight.ExtraBold
                        )
                            TextField(
                                value = toDoItemTitle,
                        onValueChange = { newItem ->
                            toDoItemTitle = newItem
                        }, modifier = Modifier
                        .fillMaxWidth()
                        )

                    }

                    Column(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "Descripcion de  tarea:",
                            modifier = Modifier.fillMaxWidth(),
                            fontWeight = FontWeight.ExtraBold
                        )

                        TextField(value = toDoItemBody, onValueChange = { newItem ->
                            toDoItemBody = newItem
                        }, modifier = Modifier.fillMaxWidth())
                    }



                    Column(modifier = Modifier.fillMaxWidth()) {

                        Text(text = "Icono", fontWeight = FontWeight.ExtraBold)
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            ExposedDropdownMenuBox(
                                expanded = expanded,
                                onExpandedChange = {
                                    expanded = !expanded
                                }
                            ) {
                                TextField(
                                    value = selectedText,
                                    onValueChange = {},
                                    readOnly = true,
                                    trailingIcon = {
                                        ExposedDropdownMenuDefaults.TrailingIcon(
                                            expanded = expanded
                                        )
                                    },
                                    modifier = Modifier
                                        .menuAnchor()
                                        .fillMaxWidth()
                                )

                                ExposedDropdownMenu(
                                    expanded = expanded,
                                    onDismissRequest = { expanded = false }
                                ) {
                                    DropdownMenuItem(
                                        text = { Text(text = "Tarea") },
                                        leadingIcon = {
                                            Icon(
                                                imageVector = Icons.Default.Create,
                                                contentDescription = "Tarea"
                                            )
                                        },
                                        onClick = {
                                            selectedText = "Create"
                                            expanded = false

                                        }
                                    )
                                    DropdownMenuItem(
                                        text = { Text(text = "Actividad") },
                                        leadingIcon = {
                                            Icon(
                                                imageVector = Icons.Default.Warning,
                                                contentDescription = "Actividad"
                                            )
                                        },
                                        onClick = {
                                            selectedText = "Warning"
                                            expanded = false

                                        }
                                    )
                                    DropdownMenuItem(
                                        text = { Text(text = "Horas sociales") },
                                        leadingIcon = {
                                            Icon(
                                                imageVector = Icons.Default.Home,
                                                contentDescription = "Entreno"
                                            )
                                        },
                                        onClick = {
                                            selectedText = "Home"
                                            expanded = false

                                        }
                                    )
                                    DropdownMenuItem(
                                        text = { Text(text = "Evaluacion Corta") },
                                        leadingIcon = {
                                            Icon(
                                                imageVector = Icons.Default.Face,
                                                contentDescription = "Evaluacion Corta"
                                            )
                                        },
                                        onClick = {
                                            selectedText = "Face"
                                            expanded = false

                                        }
                                    )
                                    DropdownMenuItem(
                                        text = { Text(text = "Laboratorio de Discusion") },
                                        leadingIcon = {
                                            Icon(
                                                imageVector = Icons.Default.Info,
                                                contentDescription = "Laboratorio de Discusion"
                                            )
                                        },
                                        onClick = {
                                            selectedText = "Informacion Desplegada"
                                            expanded = false

                                        }
                                    )
                                }
                            }
                        }
                    }

                    Column(modifier = Modifier.fillMaxWidth()   ) {

                        Text(text = "Color:", fontWeight = FontWeight.ExtraBold)
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            ExposedDropdownMenuBox(
                                modifier = Modifier.fillMaxWidth(),
                                expanded = expanded2,
                                onExpandedChange = {
                                    expanded2 = !expanded2
                                }
                            ) {
                                TextField(
                                    value = selectedText2,
                                    onValueChange = {},
                                    readOnly = true,
                                    trailingIcon = {
                                        ExposedDropdownMenuDefaults.TrailingIcon(
                                            expanded = expanded2
                                        )
                                    },
                                    modifier = Modifier
                                        .menuAnchor()
                                        .fillMaxWidth()
                                )

                                ExposedDropdownMenu(
                                    expanded = expanded2,
                                    onDismissRequest = { expanded2 = false }
                                ) {
                                    DropdownMenuItem(
                                        text = { Text(text = "Blanco") },
                                        onClick = {
                                            selectedText2 = "White"
                                            expanded2 = false

                                        }
                                    )
                                    DropdownMenuItem(
                                        text = { Text(text = "Negro") },
                                        onClick = {
                                            selectedText2 = "Negro"
                                            expanded2 = false

                                        }
                                    )
                                    DropdownMenuItem(
                                        text = { Text(text = "Verde") },
                                        onClick = {
                                            selectedText2 = "Green"
                                            expanded2 = false

                                        }
                                    )
                                    DropdownMenuItem(
                                        text = { Text(text = "Celeste") },
                                        onClick = {
                                            selectedText2 = "Light blue"
                                            expanded2 = false

                                        }
                                    )
                                    DropdownMenuItem(
                                        text = { Text(text = "Gris") },
                                        onClick = {
                                            selectedText2 = "Grey"
                                            expanded2 = false

                                        }
                                    )
                                }
                            }
                        }
                    }

                    Column(modifier = Modifier.fillMaxWidth()) {
                        TextButton(
                            onClick = { showDatePicker = !showDatePicker },
                            modifier = Modifier
                                .align(Alignment.Start)
                        ) {
                            Text(
                                text = "Seleccionar fecha:",
                                modifier = Modifier.fillMaxWidth(),
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 15.sp,
                                textAlign = TextAlign.Start
                            )
                        }

                        if (showDatePicker) {
                            DatePickerDialog(
                                onDismissRequest = { showDatePicker = !showDatePicker },
                                confirmButton = {
                                    Button(onClick = { showDatePicker = !showDatePicker }) {
                                        Text(text = "Seleccionar")
                                    }
                                }) {
                                    DatePicker(state = dateState)
                            }
                        }
                        dateSelected?.let {

                            val dateFormatted =
                                Instant.ofEpochMilli(it).atZone(ZoneId.of("UTC")).toLocalDate()

                            Text(
                                text = "Fecha que se ha elegido: ${dateFormatted.dayOfMonth}/${dateFormatted.month}/${dateFormatted.year}",
                                modifier = Modifier.fillMaxWidth(),
                                fontWeight = FontWeight.Bold
                            )
                        }


                    }

                    Button(
                        onClick = {

                        }, modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                    ) {
                        Text(text = "Agregar tarea", fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }

}

@Preview
@Composable
fun TaskPreview(){
    Task(navController = rememberNavController())
}