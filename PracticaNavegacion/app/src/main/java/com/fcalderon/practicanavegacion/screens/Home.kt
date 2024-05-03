package com.fcalderon.practicanavegacion.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.fcalderon.practicanavegacion.components.BottomBarNavigation

data class TextItem(
    val title: String,
    val description: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavController) {

val textItems= listOf(
    TextItem("Corto Calulo 2", "Corto 2 de calculo 2, el cual sera de integrales"),
    TextItem("Taller 1 PDM", "Estudiando lazycolumn, barnavigation"),
    TextItem("Corto WEB", "JAVASCRIPT"),
    TextItem("Corto Evaluado ", "El cual sera de integrales"),
    TextItem("Corto FIsICA 2", "Corto 2 de calculo 2, el cual sera de integrales"),
    TextItem("Corto Calulo 2", "Corto 2 de calculo 2, el cual sera de integrales"),
    TextItem("Corto Calulo 2", "Corto 2 de calculo 2, el cual sera de integrales"),
    TextItem("Corto Calulo 2", "Corto 2 de calculo 2, el cual sera de integrales"),
    TextItem("Corto Calulo 2", "Corto 2 de calculo 2, el cual sera de integrales"),
    TextItem("Corto Calulo 2", "Corto 2 de calculo 2, el cual sera de integrales"),
    TextItem("Corto Calulo 2", "Corto 2 de calculo 2, el cual sera de integrales"),
    TextItem("Corto Calulo 2", "Corto 2 de calculo 2, el cual sera de integrales"),
    TextItem("Corto Calulo 2", "Corto 2 de calculo 2, el cual sera de integrales"),
    TextItem("Corto Calulo 2", "Corto 2 de calculo 2, el cual sera de integrales"),
    TextItem("Corto Calulo 2", "Corto 2 de calculo 2, el cual sera de integrales"),
    TextItem("Corto Calulo 2", "Corto 2 de calculo 2, el cual sera de integrales"),
    TextItem("Corto Calulo 2", "Corto 2 de calculo 2, el cual sera de integrales"),
    TextItem("Corto Calulo 2", "Corto 2 de calculo 2, el cual sera de integrales"),
    TextItem("Corto Calulo 2", "Corto 2 de calculo 2, el cual sera de integrales"),
    TextItem("Corto Calulo 2", "Corto 2 de calculo 2, el cual sera de integrales"),
    TextItem("Corto Calulo 2", "Corto 2 de calculo 2, el cual sera de integrales"),
    TextItem("Corto Calulo 2", "Corto 2 de calculo 2, el cual sera de integrales"),


    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Home")
                },
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
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                items(textItems) { item ->
                    TextItemView(item)
                }
            }
        }
    }
}

@Composable
fun TextItemView(textItem: TextItem) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = textItem.title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Text(text = textItem.description, fontSize = 14.sp)
    }
}