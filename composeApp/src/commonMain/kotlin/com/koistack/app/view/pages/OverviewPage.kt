package com.koistack.app.view.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.koistack.app.controller.Controller
import kotlinx.coroutines.CoroutineScope

@Composable
fun OverviewPage(
    controller: Controller,
    scope: CoroutineScope
) {
    Column() {
        Text("This is the OverviewPage")
    }
}