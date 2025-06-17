package com.koistack.app.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.koistack.app.controller.TaskController
import com.koistack.app.model.Task
import com.koistack.app.view.components.TaskCard

@Composable
fun DefaultTaskPage(
    taskController: TaskController,
    innerPadding: PaddingValues
) {
    //List of values and variables required:
    val listOfTasks = taskController.getTasks()

    //Outer Column with all the content to be seen in the scaffold
    Column(
        modifier = Modifier
            .padding(innerPadding)
    ) {
        //First Row with the calender items:
        Row() {
            repeat(5) {
                Column(
                    modifier = Modifier
                        .padding(5.dp)
                        .border(width = 1.dp, color = Color.Red)
                        .weight(1f)
                ) {
                    Text(
                        text = "Date number $it",
                    )
                }
            }
        }


        //Second Row with the categories:
        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
                .background(color = Color.Gray)
        ) {
            repeat(7) {
                Column(
                    modifier = Modifier
                        .padding(5.dp)
                        .border(width = 1.dp, color = Color.Blue)
                        .padding(5.dp)
                ) {
                    Text(
                        text = "Category number $it",
                    )
                }
            }
        }


        //Final Column that has the task Items:
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            listOfTasks.forEach {
                TaskCard(it)
            }
        }

    }
}