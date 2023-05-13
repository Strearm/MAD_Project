package com.example.mad_project.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun DetailRelaxScreen(navController: NavController, id:Long?)
{
    id?.let {
        Column() {
            Text(text = "Hallo")
        }
    }
}