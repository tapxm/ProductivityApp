package com.koistack.app.view.components

sealed class NavDestinantion (val route: String) {
    object Home : NavDestinantion("home")
    object Tasks : NavDestinantion("tasks")
    object User : NavDestinantion("user")
    object Calender : NavDestinantion("calender")
}