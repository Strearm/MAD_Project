package com.example.mad_project.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mad_project.navigation.HOME_GRAPH_ROUTE

@Composable
fun SimpleTopAppBar(arrowBackClicked: () -> Unit = {}, navController: NavHostController, content: @Composable () -> Unit) {

    TopAppBar(elevation = 3.dp) {
        Row(modifier = Modifier
            .padding(10.dp),) {
            Icon(imageVector = Icons.Default.ArrowBack,
                contentDescription = "Arrow back",
                modifier = Modifier.clickable {
                    arrowBackClicked()
                }
            )
        }
        Spacer(modifier = Modifier.width(20.dp))
        Row() {
            content()
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(onClick = { navController.navigate(HOME_GRAPH_ROUTE){popUpTo(HOME_GRAPH_ROUTE)}  }) {
                Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
            }
        }
    }
}

    @Composable
    fun HomeTopAppBar(
        title: String = "Home"
    ) {
        TopAppBar(
            title = { Text(title) }
        )
    }
