package com.example.mad_project.learning

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import coil.compose.AsyncImage
import com.example.mad_project.ui.theme.Purple200

@Composable
fun LearningRow(learning: Learning, onItemClick:(String) -> Unit) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .clickable { onItemClick(learning.id) }
        .padding(15.dp),
        shape = RoundedCornerShape(corner = CornerSize(20.dp)),
        elevation = 5.dp
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentAlignment = Alignment.BottomStart,
        ) {
            
            LearningImages(learning = learning)
            LearningTitles(learning = learning)

        }
    }
}

@Composable
fun LearningImages(learning: Learning){
    AsyncImage(
        model = learning.image,
        contentScale = ContentScale.Crop,
        contentDescription = "Learning Method",
        modifier = Modifier
            .fillMaxWidth()
    )
}

@Composable
fun LearningTitles(learning: Learning) {
    Column(Modifier.background(Purple200, shape = RoundedCornerShape(20.dp))) {
        Text(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth(),
            text = learning.title.uppercase(),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
        Text(
            modifier = Modifier
                .padding(start = 15.dp, end = 15.dp, bottom = 15.dp)
                .fillMaxWidth(),
            text = learning.subtitle,
            color = Color.Gray
        )
    }
}