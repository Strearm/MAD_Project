package com.example.mad_project.relax

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.mad_project.widgets.SimpleTopAppBar
import com.example.mad_project.widgets.WebView

@Composable
fun DetailRelaxScreen(navController: NavHostController, id: Long?, viewModel: RelaxViewModel, videoUrl: String) {
    val relaxTechnique: RelaxTechnique = viewModel.filterRelaxTechnique(id.toString())

    Column {
        SimpleTopAppBar(arrowBackClicked = { navController.popBackStack() }, navController = navController) {
            Text(text = relaxTechnique.title)
        }

        Box(modifier = Modifier.fillMaxWidth().height(200.dp)) {
            WebView(videoUrl = "https://www.youtube.com/embed/$videoUrl")
        }

        Card(
            shape = RoundedCornerShape(8.dp),
            elevation = 8.dp,
            modifier = Modifier.padding(8.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Inventor: ${relaxTechnique.inventor}")
                Text(text = "Description: ${relaxTechnique.description}")
            }
        }
    }
}