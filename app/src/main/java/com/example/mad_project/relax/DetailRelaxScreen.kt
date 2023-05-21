package com.example.mad_project.relax

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mad_project.widgets.SimpleTopAppBar

@Composable
fun DetailRelaxScreen(navController: NavController, id: Long?, viewModel: RelaxViewModel) {

    val relaxTechnique: RelaxTechnique = viewModel.filterRelaxTechnique(id.toString())

    Column {
        SimpleTopAppBar(arrowBackClicked = { navController.popBackStack() }) {
            Text(text = relaxTechnique.title)
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
