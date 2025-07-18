package com.koistack.app.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import platform.UIKit.UIScreen

@OptIn(ExperimentalComposeUiApi::class)
@Composable
actual fun getScreenHeight() :Dp {
    val screenHeight = LocalWindowInfo.current.containerSize.height.pxToDp().dp

    return screenHeight
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
actual fun getScreenWidth(): Dp {
    val screenWidth = LocalWindowInfo.current.containerSize.width.pxToDp().dp

    return screenWidth
}


fun Int.pxToDp() : Double {
    return this / UIScreen.mainScreen.scale
}