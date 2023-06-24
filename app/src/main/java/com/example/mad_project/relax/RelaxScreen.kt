package com.example.mad_project.relax

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mad_project.navigation.Screen
import com.example.mad_project.ui.theme.Purple500
import com.example.mad_project.widgets.BottomBar
import com.example.mad_project.widgets.SimpleTopAppBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RelaxScreen(navController: NavHostController) {
    val relaxTechniques = getRelaxTechnique()

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SimpleTopAppBar(arrowBackClicked = { navController.popBackStack() }, navController = navController) {
            Text(text = "Relaxing Techniques")
        }
        RelaxIntro()
        relaxTechniques.forEach { relaxTechnique ->
            RelaxButtons(relaxTechnique) {
                navController.navigate(route = Screen.Detail_Relax.passId(id = relaxTechnique.id))
            }
        }

        Scaffold(bottomBar = { BottomBar(navController = navController) }) {

        }

    }
}


@Composable
fun RelaxIntro() {
    Box(
        modifier = Modifier
            .padding(start = 15.dp, top = 25.dp, end = 15.dp, bottom = 15.dp)
            .fillMaxWidth()
    ) {
        Text(
            buildAnnotatedString {
                withStyle(
                    style = ParagraphStyle(
                        textAlign = TextAlign.Center,
                        lineHeight = 30.sp
                    )
                ) {
                    append("Click on the relaxing technique to get more ")
                    withStyle(style = SpanStyle(color = Purple500)) {
                        append("information ")
                    }
                    append(
                        "about the relaxing technique you can use. Relaxing techniques can have a high benefit to our mental health during stressful learning times."
                    )
                }
            },
            modifier = Modifier.padding(10.dp)
        )
    }
}

@Composable
fun RelaxButtons(relaxTechnique: RelaxTechnique, onClick: () -> Unit) {
    val isClicked = remember { mutableStateOf(false) }
    val projectGreen = Color(0xFF71C55D)

    Button(
        modifier = Modifier
            .padding(top = 40.dp)
            .fillMaxWidth()
            .padding(horizontal = 70.dp)
            .border(2.dp, color = Purple500, RoundedCornerShape(50)),  // Rounded border
        colors = ButtonDefaults.buttonColors(backgroundColor = if (isClicked.value) projectGreen else Color.White),
        onClick = {
            onClick()
            isClicked.value = !isClicked.value
        },
        shape = RoundedCornerShape(50)  // Rounded button shape
    ) {
        Text(text = relaxTechnique.title)
    }
}

