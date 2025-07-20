package com.koistack.app.view.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.koistack.app.controller.TaskController
import com.koistack.app.model.local.entities.Task
import com.koistack.app.utils.ColorTheme
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import productivityapp.composeapp.generated.resources.Res
import productivityapp.composeapp.generated.resources.allDrawableResources
import productivityapp.composeapp.generated.resources.default


@OptIn(ExperimentalResourceApi::class, ExperimentalFoundationApi::class)
@Composable
fun TaskCard(task: Task) {

    val taskController = TaskController()

    val colorTheme = ColorTheme

    val scope = rememberCoroutineScope()


    Row(
        modifier = Modifier
            .height(IntrinsicSize.Min)
            .padding(10.dp)
//            .border(width = Dp.Hairline, shape = RoundedCornerShape(25.dp), color = Color.Red)
            .clip(shape = RoundedCornerShape(10.dp))
            .background(colorTheme.topBackground)
            .padding(10.dp)
            .combinedClickable(
                onClick = {
                    taskController.onPressChangeTheme()
                },
                onLongClick = {
                    scope.launch {
                        taskController.onLongPressDelete(task)
                    }
                }
            )


    ) {
        //Task card details
        Column(
            modifier = Modifier
                .weight(3f)
                .fillMaxSize(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            task.categoryTitle?.let {
                Text(
                    it,
                    color = colorTheme.mutedText
                )
            }

            Text(
                task.taskTitle,
                color = colorTheme.text,
                fontSize = 20.sp
            )

            Text(
                task.taskDueDate,
                color = colorTheme.text
            )
        }

        //Task card image and state
        Column(
            modifier = Modifier
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                modifier = Modifier
                    .align(Alignment.End),
                painter = painterResource(
                    Res.allDrawableResources[task.categoryImageName] ?: Res.drawable.default
                ),
                contentDescription = null
            )
            Text(
                task.taskId.toString(),
                color = colorTheme.text
            )
            Text(
                task.taskIsDone.toString(),
                color = colorTheme.mutedText
            )
        }
    }

}



