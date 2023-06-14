package com.example.mad_project.relax

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mad_project.widgets.*
import kotlinx.coroutines.delay
import android.util.Log

@Composable
fun DetailRelaxScreen(navController: NavController, id: Long?, viewModel: RelaxViewModel, videoUrl: List<String>?) {
    val relaxTechnique: RelaxTechnique = viewModel.filterRelaxTechnique(id.toString())

    val filteredVideoUrls = filterVideoUrls(relaxTechnique, getRelaxTechnique())

    val shuffledVideoUrls = remember { filteredVideoUrls.shuffled() }
    val currentVideoUrlIndex = rememberSaveable { mutableStateOf(0) }
    val currentVideoUrl = remember { mutableStateOf(shuffledVideoUrls[currentVideoUrlIndex.value]) }

    Column {
        SimpleTopAppBar(arrowBackClicked = { navController.popBackStack() }) {
            Text(text = relaxTechnique.title)
        }

        Box(modifier = Modifier.fillMaxWidth().height(200.dp)) {
            WebView(videoUrl = currentVideoUrl.value)
        }

        Button(
            onClick = {
                Log.d("Button Clicked", "Button clicked")
                val unwatchedVideoUrls = shuffledVideoUrls.filterIndexed { index, _ -> index > currentVideoUrlIndex.value }
                val randomIndex = (0 until unwatchedVideoUrls.size).random()
                val newIndex = shuffledVideoUrls.indexOf(unwatchedVideoUrls[randomIndex])
                currentVideoUrlIndex.value = newIndex
                currentVideoUrl.value = shuffledVideoUrls[newIndex]
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Other Video")
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
