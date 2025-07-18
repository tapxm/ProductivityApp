package com.koistack.app.view.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import kotlinx.coroutines.CoroutineScope

@Composable
fun OverviewPage(bottomAppBarHeight: Dp) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Red)
    ) {
        Text("This is the OverviewPage")
    }
}