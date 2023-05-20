package com.example.mad_project.relax

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun DetailRelaxScreen(navController: NavController, id:Long?
)
{
     id?.let {
        Column() {
            Text(text = "Welcome to Detail Relax")
        }
    }
}