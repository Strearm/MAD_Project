package com.example.mad_project.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.mad_project.learning.Learning
import com.example.mad_project.learning.LearningViewModel
import com.example.mad_project.widgets.SimpleTopAppBar

@Composable
fun DetailLearningScreen(navController: NavController, id:Long?, viewModel: LearningViewModel)
{
    id?.let {
        Column() {
            val learning: Learning = viewModel.filterLearning(id.toString())

            SimpleTopAppBar(arrowBackClicked = { navController.popBackStack() }
            ) {
               Text(text = learning.title)
            }
            Text(text = "Welcome to Learning Relax",
                modifier = Modifier
                    .clickable { navController.popBackStack() })
        }
    }
}