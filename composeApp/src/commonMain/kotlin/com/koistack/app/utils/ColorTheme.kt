package com.koistack.app.utils

import androidx.compose.ui.graphics.Color

data class ColorTheme(
    var bottomBackground: Color,
    var middleBackground: Color,
    var topBackground: Color,
    var mainAccentColor: Color,
    var text: Color,
    var mutedText: Color,
    var border: Color
)

private val darkColorTheme = ColorTheme(
    bottomBackground = Color.hsl(
        hue = 0F, saturation = 0F, lightness = 0.00F
    ),
    middleBackground = Color.hsl(
        hue = 0F, saturation = 0F, lightness = 0.05F
    ),
    topBackground = Color.hsl(
        hue = 0F, saturation = 0F, lightness = 0.15F
    ),
    mainAccentColor = Color.hsl(
        hue = 0F, saturation = 0F, lightness = 0.15F
    ),
    text = Color.hsl(
        hue = 0F, saturation = 0F, lightness = 0.95F
    ),
    mutedText = Color.hsl(
        hue = 0F, saturation = 0F, lightness = 0.85F
    ),
    border = Color.hsl(
        hue = 0F, saturation = 0F, lightness = 0.50F
    )
)

private val lightColorTheme = ColorTheme(
    bottomBackground = Color.hsl(
        hue = 0F, saturation = 0F, lightness = 0.80F
    ),
    middleBackground = Color.hsl(
        hue = 0F, saturation = 0F, lightness = 0.85F
    ),
    topBackground = Color.hsl(
        hue = 0F, saturation = 0F, lightness = 0.95F
    ),
    mainAccentColor = Color.hsl(
        hue = 0F, saturation = 0F, lightness = 0.95F
    ),
    text = Color.hsl(
        hue = 0F, saturation = 0F, lightness = 0.00F
    ),
    mutedText = Color.hsl(
        hue = 0F, saturation = 0F, lightness = 0.10F
    ),
    border = Color.hsl(
        hue = 0F, saturation = 0F, lightness = 0.50F
    )
)


fun setColorTheme(
    inDarkMode: Boolean,
    appColorHue: Float?
): ColorTheme {

    val colorTheme = if (inDarkMode) {
        darkColorTheme
    } else {
        lightColorTheme
    }

    if (appColorHue != null) {
        darkColorTheme.mainAccentColor = Color.hsl(
            hue = appColorHue, saturation = 0.30F, lightness = 0.50F
        )

        lightColorTheme.mainAccentColor = Color.hsl(
            hue = appColorHue, saturation = 0.70F, lightness = 0.50F
        )
    }

    return colorTheme
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



