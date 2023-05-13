package com.example.mad_project.navigation

const val learningId = "learningId"
const val relaxId = "relaxId"

const val ROOT_GRAPH_ROUTE = "root"
const val HOME_GRAPH_ROUTE = "home"
const val LEARNING_GRAPH_ROUTE = "learning"
const val RELAX_GRAPH_ROUTE = "relax"
const val TIMER_GRAPH_ROUTE = "timer"

sealed class Screen(val route: String) {
    object Home : Screen(route = "home_screen")
    object Learning: Screen(route = "learning_screen")
    object Detail_Learning : Screen(route = "detail_learning_screen/{$learningId}") {
        fun passId(id: String): String {
            return this.route.replace(oldValue = "{$learningId}", newValue = id)
        }
    }
    object Relax: Screen(route = "relax_screen")
    object Detail_Relax : Screen(route = "detail_relax_screen/${relaxId}") {
        fun passId(id: String): String {
            return this.route.replace(oldValue = "{$relaxId}", newValue = id)
        }
    }
    object Timer: Screen(route = "timer_screen")
}