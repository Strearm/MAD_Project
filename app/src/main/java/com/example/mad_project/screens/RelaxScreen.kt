package com.example.mad_project.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mad_project.navigation.LEARNING_GRAPH_ROUTE
import com.example.mad_project.navigation.RELAX_GRAPH_ROUTE
import com.example.mad_project.navigation.Screen

@Composable
fun RelaxScreen(navController: NavController)
{
    Column(modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            modifier = Modifier
                .padding(top = 150.dp),
            text = "WELCOME TO RELAX"
        )

        Text(
            modifier = Modifier
                .padding(top = 150.dp)
                .clickable { navController.navigate(route = Screen.Detail_Relax.passId(id = "1")) },
            text = "RELAX Detail"
        )
    }
}