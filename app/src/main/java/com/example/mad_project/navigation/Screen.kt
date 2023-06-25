package com.example.mad_project.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

const val learningId = "learningId"
const val relaxId = "relaxId"

const val ROOT_GRAPH_ROUTE = "root"
const val HOME_GRAPH_ROUTE = "home"
const val LEARNING_GRAPH_ROUTE = "learning"
const val RELAX_GRAPH_ROUTE = "relax"
const val TASKS_GRAPH_ROUTE = "tasks"

sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    object Home : Screen(
        route = "home_screen",
        title = "Home",
        icon = Icons.Default.Home)
    object Learning: Screen(
        route = "learning_screen",
        title = "Learning",
        icon = Icons.Default.Edit
    )
    object Tasks: Screen(
        route = "task_Screen",
        title = "tasks",
        icon = Icons.Default.Check
    )
    object addTasks: Screen(
        route = "add_task_Screen",
        title = "add_tasks",
        icon = Icons.Default.Edit
    )
    object Detail_Learning : Screen(route = "detail_learning_screen/{$learningId}",title = "Detail Learning", icon = Icons.Default.Edit) {
        fun passId(id: String): String {
            return this.route.replace(oldValue = "{$learningId}", newValue = id)
        }
    }
    object Relax: Screen(
        route = "relax_screen",
        title = "Relax",
        icon = Icons.Default.Face)
    object Detail_Relax : Screen(route = "detail_relax_screen/{$relaxId}",title = "Detail Relax", icon = Icons.Default.Face) {
        fun passId(id: String): String {
            return this.route.replace(oldValue = "{$relaxId}", newValue = id)
        }
    }
    object Timer: Screen(
        route = "timer_screen",
        title = "Timer",
        icon = Icons.Default.Refresh)
}