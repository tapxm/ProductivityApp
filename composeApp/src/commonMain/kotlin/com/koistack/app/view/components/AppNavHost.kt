package com.koistack.app.view.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.koistack.app.controller.TaskController
import com.koistack.app.view.CalenderPage
import com.koistack.app.view.DefaultTaskPage
import com.koistack.app.view.HomePage
import com.koistack.app.view.UserPage

@Composable
fun AppNavHost(
    taskController: TaskController,
    innerPadding: PaddingValues,
    navBarRoute: String
) {

    when (navBarRoute) {
        NavDestinantion.Home.route -> HomePage(
            taskController = taskController,
            innerPadding = innerPadding
        )

        NavDestinantion.Tasks.route -> DefaultTaskPage(
            taskController = taskController,
            innerPadding = innerPadding
        )

        NavDestinantion.User.route -> UserPage(
            taskController = taskController,
            innerPadding = innerPadding
        )

        NavDestinantion.Calender.route -> CalenderPage(
            taskController = taskController,
            innerPadding = innerPadding
        )
    }
}
