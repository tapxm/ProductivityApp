package com.koistack.app.view.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.koistack.app.controller.RepositoryProvider
import com.koistack.app.model.repository.TaskRepository
import com.koistack.app.utils.ColorTheme
import com.koistack.app.view.components.TaskCard

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TaskListPage() {

    val taskRepository: TaskRepository = RepositoryProvider.taskRepository

    val taskListFlow = taskRepository.getAllTasks()

    val taskList by taskListFlow.collectAsStateWithLifecycle(initialValue = emptyList())

    //Column with all the tasks displayed
    Column(

    ) {

        //Title
        Column (
            modifier = Modifier
                .padding(bottom = 10.dp)
                .fillMaxWidth()
                .background(ColorTheme.bottomBackground)
        ) {
            Text(
                text = "This is the Task Page",
                color = ColorTheme.text,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }

        //Dates
        Row(
            modifier = Modifier
                .padding(bottom = 10.dp)
        ) {
            repeat(5) {
                Text(
                    text = "this is date #$it",
                    color = ColorTheme.text,
                    modifier = Modifier
                        .padding(horizontal = 5.dp)
                        .background(color = ColorTheme.topBackground)
                        .weight(1f)
                        .border(width = Dp.Hairline, color = Color.Red)
                )
            }
        }

        //Categories
        Row(
            modifier = Modifier
                .padding(bottom = 10.dp)
                .horizontalScroll(rememberScrollState())
        ) {
            repeat(10) {
                Text(
                    text = "category #$it",
                    color = ColorTheme.text,
                    modifier = Modifier
                        .padding(horizontal = 5.dp)
                        .background(color = ColorTheme.topBackground)

                )
            }
        }

        //Scrollable List of Tasks
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(bottom = 40.dp)

        ) {
            for (task in taskList) {
                TaskCard(task)
            }
        }

    }
}