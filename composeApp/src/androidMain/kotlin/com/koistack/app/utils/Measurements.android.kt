package com.koistack.app.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
actual fun getScreenHeight():Dp {
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp

    return screenHeight
}

@Composable
actual fun getScreenWidth(): Dp {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp

    return screenWidth
}