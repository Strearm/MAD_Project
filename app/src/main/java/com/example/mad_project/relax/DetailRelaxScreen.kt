package com.example.mad_project.relax

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mad_project.navigation.Screen
import com.example.mad_project.widgets.SimpleTopAppBar
import com.example.mad_project.widgets.WebViewWrapper
import com.example.mad_project.widgets.filterVideoUrls

@Composable
fun DetailRelaxScreen(
    navController: NavHostController,
    id: Long?,
    viewModel: RelaxViewModel,
    videoUrl: List<String>?
) {
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
    val inventorExpanded = remember { mutableStateOf(false) }
    val descriptionExpanded = remember { mutableStateOf(false) }
    val bestAvoidedExpanded = remember { mutableStateOf(false) }

    LazyColumn {
        item {
            SimpleTopAppBar(
                arrowBackClicked = { navController.popBackStack() },
                navController = navController
            ) {
                Text(
                    text = relaxTechnique.title,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp
                    )
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            WebViewWrapper(videoUrl = currentVideoUrl.value)

            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
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
                            val newShuffledList = shuffledVideoUrls.shuffled()
                            currentVideoUrlIndex.value = 0
                            currentVideoUrl.value = newShuffledList[0]
                            usedVideoUrls.clear()
                            usedVideoUrls.add(currentVideoUrl.value)
                        }
                        navController.popBackStack()
                        navController.navigate(route = Screen.Detail_Relax.passId(id = relaxTechnique.id))
                    },
                    modifier = Modifier.padding(vertical = 16.dp)
                ) {
                    Text(text = "Change Video")
                }
            }
            Card(
                shape = RoundedCornerShape(8.dp),
                elevation = 8.dp,
                modifier = Modifier.padding(8.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    ExpandableHeader(
                        headerText = "Inventor",
                        isExpanded = inventorExpanded.value,
                        onClick = { inventorExpanded.value = !inventorExpanded.value }
                    )
                    ExpandableContent(
                        content = relaxTechnique.inventor,
                        isExpanded = inventorExpanded.value
                    )

                    ExpandableHeader(
                        headerText = "Description",
                        isExpanded = descriptionExpanded.value,
                        onClick = { descriptionExpanded.value = !descriptionExpanded.value }
                    )
                    ExpandableContent(
                        content = relaxTechnique.description,
                        isExpanded = descriptionExpanded.value
                    )

                    ExpandableHeader(
                        headerText = "Do not use this technique",
                        isExpanded = bestAvoidedExpanded.value,
                        onClick = { bestAvoidedExpanded.value = !bestAvoidedExpanded.value }
                    )
                    ExpandableContent(
                        content = relaxTechnique.bestAvoided,
                        isExpanded = bestAvoidedExpanded.value
                    )
                }
            }
        }
    }
}

@Composable
fun ExpandableHeader(
    headerText: String,
    isExpanded: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clickable { onClick() }
            .padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = headerText,
                style = TextStyle(color = Color(0xFF006400), fontSize = 20.sp),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun ExpandableContent(content: String, isExpanded: Boolean) {
    AnimatedVisibility(visible = isExpanded) {
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .width(680.dp)
        ) {
            Text(
                text = content,
                style = TextStyle(fontSize = 16.sp, lineHeight = 24.sp),
                modifier = Modifier.padding(8.dp, 4.dp)
            )
        }
    }
}