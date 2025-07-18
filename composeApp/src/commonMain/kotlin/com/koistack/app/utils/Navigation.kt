package com.koistack.app.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import productivityapp.composeapp.generated.resources.Res
import productivityapp.composeapp.generated.resources.image

object Navigation {
    var currentPosition by mutableStateOf("")
        private set

    val mapOfNavItemsToIcons: Map<String, ImageVector> =
        mapOf(
            "overview" to Icons.Default.Home,
            "tasks" to Icons.Default.Home,
            "calender" to Icons.Default.Home,
            "settings" to Icons.Default.Home
        )
    val locations = listOf("overview", "tasks", "calender", "settings")

    fun setNewPosition(locationName: String){
        currentPosition = locationName
    }
}