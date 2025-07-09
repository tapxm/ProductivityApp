package com.koistack.app.view

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.koistack.app.controller.Controller
import com.koistack.app.view.components.BottomNavBar
import com.koistack.app.view.pages.TaskListPage
import kotlinx.coroutines.CoroutineScope

@Composable
fun mainScreen(
    controller: Controller,
    scope: CoroutineScope
) {

    val currentLocation = remember { mutableStateOf("hello") }
    val listOfNavItems = listOf("bye", "hello")

    Scaffold(
        contentWindowInsets = WindowInsets.safeDrawing,
        bottomBar = {
            BottomNavBar(
                currentLocation,
                listOfNavItems,
                content = { it ->
                    Text(it)
                }
            )
        },
        content = { paddingValues ->
            TaskListPage(paddingValues, controller, scope)
        },
    )
}