package com.koistack.app.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.koistack.app.controller.TaskController

@Composable
fun CalenderPage(
    taskController: TaskController,
    innerPadding: PaddingValues
){
    return Column(
        modifier = Modifier
            .padding(innerPadding)
    ){}
}