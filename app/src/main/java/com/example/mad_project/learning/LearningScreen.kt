package com.example.mad_project.learning

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mad_project.navigation.*
import com.example.mad_project.ui.theme.Purple500
import com.example.mad_project.widgets.SimpleTopAppBar

@Composable
fun LearningScreen(navController: NavController, viewModel: LearningViewModel)
{
    Column(modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        SimpleTopAppBar(arrowBackClicked = { navController.popBackStack() }
        ) {
            Text(text = "Learning Techniques")
        }
        InformationLearning()
        LearningList(navController, viewModel)
    }
}
@Composable
fun InformationLearning(){
    Box(modifier = Modifier
        .padding(start = 15.dp, top = 25.dp, end = 15.dp, bottom = 15.dp)
        .fillMaxWidth()
        .border(BorderStroke(2.dp, Color.Gray), shape = RoundedCornerShape(10.dp))) {
        Text(buildAnnotatedString {
                withStyle(style = ParagraphStyle(textAlign = TextAlign.Center)) {
                    append("Learning Techniques or better called, ")
                    withStyle(style = SpanStyle(color = Purple500)) {
                        append("time management ")
                    }
                    append(
                        "is very important for your stress-level.\n\n" +
                                "The everyday study life could be very tough, because of that it is more and more important to have a good time management skill.\n\n" +
                                "On this application you can have a near look at some of the techniques for time management."
                    )
                }
            },
            modifier = Modifier.padding(10.dp)
        )
    }
}

@Composable
fun LearningList(navController: NavController, viewModel: LearningViewModel){
    LazyColumn{
        items(viewModel.learningList) {learning ->
            LearningRow(learning = learning, onItemClick = {learningID ->
                navController.navigate(route = Screen.Detail_Learning.passId(learningID))
            })
        }
    }
}