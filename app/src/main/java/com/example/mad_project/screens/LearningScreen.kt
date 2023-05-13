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
import com.example.mad_project.navigation.HOME_GRAPH_ROUTE
import com.example.mad_project.navigation.Screen

@Composable
fun LearningScreen(navController: NavController)
{
    Column(modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            modifier = Modifier
                .padding(top = 150.dp),
            text = "WELCOME TO LEARNING"
        )

        Text(
            modifier = Modifier
                .padding(top = 150.dp)
                .clickable { navController.navigate(route = Screen.Detail_Learning.passId(id = "1")) },
            text = "LEARNING Detail"
        )

        Text(
            modifier = Modifier
                .padding(top = 150.dp)
                .clickable { navController.navigate(HOME_GRAPH_ROUTE) {
                    popUpTo(HOME_GRAPH_ROUTE)
                } },
            text = "Go BACK"
        )
    }
}