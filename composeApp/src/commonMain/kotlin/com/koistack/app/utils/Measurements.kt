package com.koistack.app.utils

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.Dp
import kotlin.concurrent.Volatile


class Measurements private constructor(
    val safeContentPadding: PaddingValues,
    val safeContentPaddingTop: Dp,
    val safeContentPaddingBottom: Dp,

    val screenHeight: Dp,
    val screenWidth: Dp,
) {

    companion object {

        @Volatile
        var instance: Measurements? = null

        @OptIn(ExperimentalComposeUiApi::class)
        @Composable
        fun get(): Measurements {

            val safeContentPadding: PaddingValues = WindowInsets.navigationBars.asPaddingValues()


            val measurements = instance ?: Measurements(
                safeContentPadding = safeContentPadding,
                safeContentPaddingTop = safeContentPadding.calculateTopPadding(),
                safeContentPaddingBottom = safeContentPadding.calculateBottomPadding(),

                screenHeight = getScreenHeight(),
                screenWidth = getScreenWidth(),
            )


            return measurements
        }
    }
}

@Composable
expect fun getScreenHeight() : Dp

@Composable
expect fun getScreenWidth() : Dp



