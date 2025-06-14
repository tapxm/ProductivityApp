package com.koistack.app

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.material.Text
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.BottomAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.koistack.app.controller.TaskController
import com.koistack.app.view.taskCard
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {

    val taskController = TaskController();

    //Create 10 Tasks
    repeat(10){
        taskController.createTask(title = "Task #$it", description = "This is task $it's description");
    }

    val safeDrawnPadding = WindowInsets.safeDrawing.asPaddingValues();
Column(modifier = Modifier
//    .fillMaxHeight()
    .background(color = Color.Blue)
){
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
                content = { Navbar.setNavBar() },
                backgroundColor = Color.Blue,
                contentColor = Color.White,
            )
        },
//        contentWindowInsets = ScaffoldDefaults.contentWindowInsets,
        content = { innerPadding ->
                LazyColumn(contentPadding = innerPadding, modifier = Modifier
                    .safeDrawingPadding()
                    )
                    {
                   items(taskController.allTasks.size) {
                       val currTask = taskController.allTasks[it]

                       taskCard(currTask)

//                       Card (
//                           modifier = Modifier
//                               .padding(5.dp),
//                           elevation = 5.dp
//                       ) {
//                           Column(
//                               modifier = Modifier
//                                   .fillMaxWidth()
//                                   .padding(5.dp)
//                           ){
//                               currTask.title?.let { it1 -> Text(it1) };
//                               currTask.description?.let { it2 -> Text(it2) };
//                               Text("The due date is ${currTask.dueDate}");
//                               Text("The status is ${currTask.status}")
//                           }
//                       }

                   }
                }


        }
    )
}



}