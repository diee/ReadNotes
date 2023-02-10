package ui

sealed interface Route {
    object Home : Route
    data class Detail(val id: Long) : Route
}