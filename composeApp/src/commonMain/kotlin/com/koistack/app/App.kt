package com.koistack.app

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.material.Text
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.BottomAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import org.jetbrains.compose.ui.tooling.preview.Preview

import productivityapp.composeapp.generated.resources.Res
import productivityapp.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {

    val contentPadding = WindowInsets.safeDrawing.asPaddingValues();
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
                    Text("hi", textAlign = TextAlign.Center)
                },
                backgroundColor = Color.Blue,
                contentColor = Color.White
            )
        },
        bottomBar = {
            BottomAppBar(
                content = { Navbar.setNavBar() },
                backgroundColor = Color.Blue,
                contentColor = Color.White

            )
        }
    ){}
}



}