package com.example.mad_project.learning

import androidx.compose.animation.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.mad_project.ui.theme.Purple200
import com.example.mad_project.widgets.HyperlinkText
import com.example.mad_project.widgets.SimpleTopAppBar

@Composable
fun DetailLearningScreen(navController: NavHostController, id:Long?, viewModel: LearningViewModel) {
    val learning: Learning = viewModel.filterLearning(id.toString())

    LazyColumn {
        item {
            SimpleTopAppBar(arrowBackClicked = { navController.popBackStack() }, navController = navController
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
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        shape = RoundedCornerShape(corner = CornerSize(20.dp)),
        elevation = 5.dp
    ) {
        AsyncImage(
            model = learning.image,
            contentScale = ContentScale.Crop,
            contentDescription = "Learning Method",
            modifier = Modifier
                .fillMaxWidth()
                .border(BorderStroke(5.dp, Purple200), shape = RoundedCornerShape(20.dp))
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
            .padding(start = 15.dp, end = 15.dp, bottom = 15.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(20.dp))
    ) {
        Text(text = "Short description")
    }

    Box(modifier = Modifier
        .padding(start = 15.dp, end = 15.dp)
        .fillMaxWidth()
        .border(BorderStroke(2.dp, Color.Gray), shape = RoundedCornerShape(10.dp))
        ) {
        AnimatedVisibility(
            visible = visibleShort.value,
            enter = fadeIn(),
            exit = fadeOut(),
        ) {
            Text(
                text = learning.shortDesc,
                modifier = Modifier
                    .padding(10.dp)
            )
        }
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
            .fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(20.dp))
    ) {
        Text(text = "Theory")
    }

    Box(modifier = Modifier
        .padding(start = 15.dp, end = 15.dp, bottom = 15.dp)
        .fillMaxWidth()
        .border(BorderStroke(2.dp, Color.Gray), shape = RoundedCornerShape(10.dp))
    ) {
        AnimatedVisibility(
            visible = visibleTheory.value,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            HyperlinkText(fullText = "${learning.description}\n\nSource: ${learning.source}",
                linkText = listOf(learning.source),
                hyperlinks = listOf(learning.source),
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}