package com.example.mad_project.learning

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.mad_project.widgets.SimpleTopAppBar

@Composable
fun DetailLearningScreen(navController: NavController, id:Long?, viewModel: LearningViewModel) {
    val learning: Learning = viewModel.filterLearning(id.toString())

    LazyColumn {
        item {
            SimpleTopAppBar(arrowBackClicked = { navController.popBackStack() }
            ) {
                Text(text = learning.title)
            }
            MethodImage(learning)
            ShortDesc(learning)
            Desc(learning)
        }
    }
}

@Composable
fun MethodImage(learning: Learning){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(15.dp),
        contentAlignment = Alignment.BottomStart,
    ) {
        AsyncImage(
            model = learning.image,
            contentScale = ContentScale.Crop,
            contentDescription = "Learning Method",
            modifier = Modifier.fillMaxWidth()
        )
    }
}
@Composable
fun ShortDesc(learning: Learning){
    val visibleShort = rememberSaveable {
        mutableStateOf(false)
    }
    Button(
        onClick = { visibleShort.value = !visibleShort.value },
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth()
    ) {
        Text(text = "Short description")
    }

    AnimatedVisibility(
        visible = visibleShort.value,
        enter = fadeIn(),
        exit = fadeOut(),
    ) {
        Text(
            text = learning.shortDesc,
            modifier = Modifier.padding(horizontal = 15.dp)
        )
    }
}
@Composable
fun Desc(learning: Learning) {
    val visibleTheory = rememberSaveable {
        mutableStateOf(false)
    }
    Button(
        onClick = { visibleTheory.value = !visibleTheory.value },
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth()
    ) {
        Text(text = "Theory")
    }
    AnimatedVisibility(
        visible = visibleTheory.value,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        Text(
            text = "${learning.description}\n\nSource: ${learning.source}",
            modifier = Modifier.padding(horizontal = 15.dp)
        )
    }
}