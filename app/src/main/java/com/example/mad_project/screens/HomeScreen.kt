package com.example.mad_project.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mad_project.R
import com.example.mad_project.navigation.*
import com.example.mad_project.widgets.BottomBar
import com.example.mad_project.widgets.HomeTopAppBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HomeTopAppBar()
        Image(
            painter = painterResource(R.drawable.logofarbe),
            contentDescription = "Logo",
            modifier = Modifier
                .size(300.dp)
                .align(Alignment.CenterHorizontally)
        )

        Text(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 16.dp)
                .fillMaxWidth()
                .wrapContentHeight()
                .wrapContentWidth(Alignment.CenterHorizontally),
            text = buildAnnotatedString {
                append("Welcome! We are a developer team who aspires to enhanche your life-learn balance.\n")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("How to use DevelopMental:\n")
                }
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("1. ")
                }
                append("Go to 'Learning' to choose a learning technique\n")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("2. ")
                }
                append("Go to 'Timer' to set a learning time\n")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("3. ")
                }
                append("Go to 'Relax' to choose a relaxing technique\n")
                append("Repeat until you finished your session\n")
                append("Optional: Begin with a relaxing technique")
            },
            textAlign = TextAlign.Center,
            style = TextStyle(
                lineHeight = 40.sp,
                fontSize = 16.sp
            )
        )

        Scaffold(bottomBar = { BottomBar(navController = navController) }) {

        }
    }
}
