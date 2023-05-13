package com.example.mad_project.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun DetailLearningScreen(navController: NavController, id:Long?)
{
    id?.let {
        Column() {
            Text(text = "Welcome to Learning Relax",
                modifier = Modifier
                    .clickable { navController.popBackStack() })
        }
    }
}