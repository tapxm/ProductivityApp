package com.koistack.app.utils

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

object ColorTheme {

    var inDarkMode by mutableStateOf(true)
        private set


    var bottomBackground by mutableStateOf(
        Color.hsl(
            hue = 0F, saturation = 0F, lightness = 0.00F
        )
    )
        private set

    var middleBackground by mutableStateOf(
        Color.hsl(
            hue = 0F, saturation = 0F, lightness = 0.05F
        )
    )
        private set


    var topBackground by mutableStateOf(
        Color.hsl(
            hue = 0F, saturation = 0F, lightness = 0.15F
        )
    )
        private set


    var mainAccentColor by mutableStateOf(
        Color.hsl(
            hue = 0F, saturation = 0F, lightness = 0.15F
        )
    )
        private set


    var text by mutableStateOf(
        Color.hsl(
            hue = 0F, saturation = 0F, lightness = 0.95F
        )
    )
        private set


    var mutedText by mutableStateOf(
        Color.hsl(
            hue = 0F, saturation = 0F, lightness = 0.85F
        )
    )
        private set


    var border by mutableStateOf(
        Color.hsl(
            hue = 0F, saturation = 0F, lightness = 0.50F
        )
    )
        private set


    private fun setDarkModeTheme() {

        inDarkMode = true

        bottomBackground = Color.hsl(
            hue = 0F, saturation = 0F, lightness = 0.00F
        )

        middleBackground = Color.hsl(
            hue = 0F, saturation = 0F, lightness = 0.05F
        )

        topBackground = Color.hsl(
            hue = 0F, saturation = 0F, lightness = 0.15F
        )

        mainAccentColor = Color.hsl(
            hue = 0F, saturation = 0F, lightness = 0.15F
        )

        text = Color.hsl(
            hue = 0F, saturation = 0F, lightness = 0.95F
        )

        mutedText = Color.hsl(
            hue = 0F, saturation = 0F, lightness = 0.85F
        )

        border = Color.hsl(
            hue = 0F, saturation = 0F, lightness = 0.50F
        )

    }


    private fun setLightModeTheme() {

        inDarkMode = false

        bottomBackground = Color.hsl(
            hue = 0F, saturation = 0F, lightness = 0.80F
        )
        middleBackground = Color.hsl(
            hue = 0F, saturation = 0F, lightness = 0.85F
        )
        topBackground = Color.hsl(
            hue = 0F, saturation = 0F, lightness = 0.95F
        )
        mainAccentColor = Color.hsl(
            hue = 0F, saturation = 0F, lightness = 0.95F
        )
        text = Color.hsl(
            hue = 0F, saturation = 0F, lightness = 0.00F
        )
        mutedText = Color.hsl(
            hue = 0F, saturation = 0F, lightness = 0.10F
        )
        border = Color.hsl(
            hue = 0F, saturation = 0F, lightness = 0.50F
        )
    }


    fun setColorTheme(
        setColorThemeHue: Float?,
        setToDarkMode: Boolean?
    ) {

        setToDarkMode?.let {

            if (it)
                this.setDarkModeTheme()
            else
                this.setLightModeTheme()
        }

        setColorThemeHue?.let {
            mainAccentColor =

                if (inDarkMode) {
                    Color.hsl(
                        hue = it, saturation = 0.30F, lightness = 0.50F
                    )
                } else {
                    Color.hsl(
                        hue = it, saturation = 0.70F, lightness = 0.50F
                    )
                }
        }


    }
}


/*
val darkModeTheme: MutableMap<String, Color> = mutableMapOf(
    "bottomBackground" to Color.hsl(
        hue = 0F, saturation = 0F, lightness = 0.00F
    ),

    "middleBackground" to Color.hsl(
        hue = 0F, saturation = 0F, lightness = 0.05F
    ),

    "topBackground" to Color.hsl(
        hue = 0F, saturation = 0F, lightness = 0.15F
    ),

    "mainAccentColor" to Color.hsl(
        hue = 0F, saturation = 0F, lightness = 0.15F
    ),

    "text" to Color.hsl(
        hue = 0F, saturation = 0F, lightness = 0.95F
    ),

    "mutedText" to Color.hsl(
        hue = 0F, saturation = 0F, lightness = 0.85F
    ),

    "border" to Color.hsl(
        hue = 0F, saturation = 0F, lightness = 0.50F
    )
)

val lightModeTheme: MutableMap<String, Color> = mutableMapOf(
    "bottomBackground" to Color.hsl(
        hue = 0F, saturation = 0F, lightness = 0.80F
    ),

    "middleBackground" to Color.hsl(
        hue = 0F, saturation = 0F, lightness = 0.85F
    ),

    "topBackground" to Color.hsl(
        hue = 0F, saturation = 0F, lightness = 0.95F
    ),

    "mainAccentColor" to Color.hsl(
        hue = 0F, saturation = 0F, lightness = 0.95F
    ),

    "text" to Color.hsl(
        hue = 0F, saturation = 0F, lightness = 0.00F
    ),

    "mutedText" to Color.hsl(
        hue = 0F, saturation = 0F, lightness = 0.10F
    ),

    "border" to Color.hsl(
        hue = 0F, saturation = 0F, lightness = 0.50F
    )
)
*/



