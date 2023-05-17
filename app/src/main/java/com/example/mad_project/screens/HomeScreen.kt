package com.example.mad_project.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mad_project.navigation.*
import com.example.mad_project.widgets.HomeTopAppBar

@Composable
fun HomeScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        HomeTopAppBar() {
            
        }
        Text(
            modifier = Modifier
                .padding(top = 150.dp)
                .clickable { navController.navigate(RELAX_GRAPH_ROUTE) },
            text = "RELAX"
        )

        Text(
            modifier = Modifier
                .padding(top = 150.dp)
                .clickable { navController.navigate(LEARNING_GRAPH_ROUTE) },
            text = "LEARNING"
        )

        Text(
            modifier = Modifier
                .padding(top = 150.dp)
                .clickable { navController.navigate(Screen.Timer.route) },
            text = "TIMER"
        )
    }
}