package com.koistack.app

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Card
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.koistack.app.controller.TaskController
import com.koistack.app.view.CreateTaskPage
import com.koistack.app.view.DefaultTaskPage
import com.koistack.app.view.components.Navbar
import com.koistack.app.view.components.TaskCard
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.koistack.app.view.components.AppNavHost
import kotlinx.coroutines.joinAll
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


@Composable
@Preview
fun App() {

    val taskController = TaskController();
    
    var currentPage by remember { mutableStateOf("tasks") }

    //Create 10 Tasks
    repeat(10) {
        taskController.createTask(
            title = "Task #$it",
            description = "This is task $it's description"
        );
    }

    val safeDrawnPadding = WindowInsets.safeDrawing.asPaddingValues();
    Column(
        modifier = Modifier
//    .fillMaxHeight()
            .background(color = Color.Blue)
    ) {
        Scaffold(
            modifier = Modifier
                .windowInsetsPadding(WindowInsets.safeDrawing),
            topBar = {

                TopAppBar(
                    title = {
                        Text("This is a questionable title, cant think of anything longer, still cant think of anything longer")

                    },

                    backgroundColor = Color.Blue,
                    contentColor = Color.White
                )
            },
            bottomBar = {
                BottomAppBar(
                    content = { currentPage = Navbar() },
                    backgroundColor = Color.Blue,
                    contentColor = Color.White,
                )
            },
//        contentWindowInsets = ScaffoldDefaults.contentWindowInsets,

            content = { innerPadding ->
                AppNavHost(
                    taskController = taskController,
                    innerPadding = innerPadding,
                    navBarRoute = currentPage
                )


            }

        )
    }
}





