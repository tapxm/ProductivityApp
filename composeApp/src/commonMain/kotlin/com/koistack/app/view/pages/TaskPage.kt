package com.koistack.app.view.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.koistack.app.controller.Controller
import kotlinx.coroutines.CoroutineScope

@Composable
fun TaskListPage(
    paddingValues: PaddingValues,
    controller: Controller,
    scope: CoroutineScope
) {
    Column(
        modifier = Modifier
            .padding(paddingValues)

    ){
        Text("This is the TasklistPage")
    }
}