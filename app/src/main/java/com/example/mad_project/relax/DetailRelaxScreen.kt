package com.example.mad_project.relax

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mad_project.widgets.*
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Composable
fun DetailRelaxScreen(navController: NavController, id: Long?, viewModel: RelaxViewModel, videoUrl: List<String>?) {
    val relaxTechnique: RelaxTechnique = viewModel.filterRelaxTechnique(id.toString())

    val filteredVideoUrls = filterVideoUrls(relaxTechnique, getRelaxTechnique())

    val shuffledVideoUrls = remember { filteredVideoUrls.shuffled() }
    val usedVideoUrls = remember { mutableStateListOf<String>() }
    val currentVideoUrlIndex = rememberSaveable { mutableStateOf(0) }
    val currentVideoUrl = remember {
        mutableStateOf(
            shuffledVideoUrls[currentVideoUrlIndex.value]
        )
    }

    Column {
        SimpleTopAppBar(arrowBackClicked = { navController.popBackStack() }) {
            Text(text = relaxTechnique.title)
        }

        WebViewWrapper(videoUrl = currentVideoUrl.value)


        Button(
            onClick = {
                if (currentVideoUrlIndex.value < shuffledVideoUrls.size - 1) {
                    val unwatchedVideoUrls =
                        shuffledVideoUrls.filterIndexed { index, _ -> index > currentVideoUrlIndex.value }
                    val randomIndex = (0 until unwatchedVideoUrls.size).random()
                    val newIndex = shuffledVideoUrls.indexOf(unwatchedVideoUrls[randomIndex])
                    currentVideoUrlIndex.value = newIndex
                    currentVideoUrl.value = shuffledVideoUrls[newIndex]
                    usedVideoUrls.add(currentVideoUrl.value)
                } else {
                    // Wenn alle Videos gesehen wurden, mische die Liste erneut und starte von vorne
                    val newShuffledList = shuffledVideoUrls.shuffled()
                    currentVideoUrlIndex.value = 0
                    currentVideoUrl.value = newShuffledList[0]
                    usedVideoUrls.clear()
                    usedVideoUrls.add(currentVideoUrl.value)
                }
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
                Text(
                    text = "Inventor:",
                    style = TextStyle(color = Color(0xFF006400), fontSize = 20.sp)
                )
                Text(
                    text = "${relaxTechnique.inventor}\n",
                    style = TextStyle(fontSize = 16.sp)
                )
                Text(
                    text = "Description:",
                    style = TextStyle(color = Color(0xFF006400), fontSize = 20.sp)
                )
                Text(
                    text = "${relaxTechnique.description}\n",
                    style = TextStyle(fontSize = 16.sp)
                )
                Text(
                    text = "Do not use this technique:",
                    style = TextStyle(color = Color(0xFF006400), fontSize = 20.sp)
                )
                Text(
                    text = "${relaxTechnique.bestAvoided}\n",
                    style = TextStyle(fontSize = 16.sp)
                )
            }
        }
    }
}

