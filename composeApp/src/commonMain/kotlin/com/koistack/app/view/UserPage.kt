package com.koistack.app.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.koistack.app.controller.TaskController

@Composable
fun UserPage (
    taskController: TaskController,
    innerPadding: PaddingValues
) {
    Column(modifier = Modifier
        .padding(innerPadding)
        .fillMaxHeight()
    ){
        Text(
            "USER SETTINGS",
            modifier = Modifier
                .fillMaxHeight(),
            textAlign = TextAlign.Center
        )
    }
}