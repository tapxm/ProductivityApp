package com.koistack.app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.koistack.app.view.MainScreen
import com.koistack.app.view.mainScreenContent
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App() {
    MainScreen()

//    Box(
//        contentAlignment = Alignment.TopCenter,
//        modifier = Modifier
//            .fillMaxSize()
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(color = Color.Red)
//        ) {}
//        Box(
//            modifier = Modifier
//                .align(Alignment.BottomCenter)
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(color = Color.Red)
//            )
//        }
//
//    }
}









