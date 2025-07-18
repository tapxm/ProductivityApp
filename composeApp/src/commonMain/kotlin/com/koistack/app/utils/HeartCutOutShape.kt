package com.koistack.app.utils

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection


/*
* Accidental cool result!! Understand later
* */


class HeartCutOutShape (
    private val cutOutSize: Dp
) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {

        val cutOutSizeInPx = with(density) {cutOutSize.toPx()}

        val bezierShape = Path().apply {

            //Start at point after "CUT-OUT"
            moveTo(
                x = (size.width / 2) + cutOutSizeInPx,
                y = 0f
            )

            //Horizontal line to right side, x axis change
            lineTo(
                x = size.width,
                y = 0f
            )

            //Vertical line to bottom side, y axis change
            lineTo(
                x = size.width,
                y = size.height
            )

            //Horizontal line to right side, x axis change
            lineTo(
                x = 0f,
                y = size.height
            )

            //Vertical line to top side, y axis change
            lineTo(
                x = 0f,
                y = 0f
            )

            //Horizontal line to point before "CUT-OUT", x axis change
            lineTo(
                x = (size.width / 2) - cutOutSizeInPx/2,
                y = 0f
            )

            cubicTo(
                //First Control coordinates
                x1 = (size.width / 2) - cutOutSizeInPx/2,
                y1 = cutOutSizeInPx / 4,

                //Second Control coordinates
                x2 = size.width / 2,
                y2 = cutOutSizeInPx / 4,

                //End Point coordinates
                x3 = size.width / 2,
                y3 = cutOutSizeInPx / 2
            )

            cubicTo(

                //First Control coordinates
                x1 = size.width / 2,
                y1 = cutOutSizeInPx / 4,

                //Second Control coordinates
                x2 = (size.width / 2) + cutOutSizeInPx/2,
                y2 = cutOutSizeInPx / 4,

                //Final Point coordinates
                x3 = (size.width / 2) + (cutOutSizeInPx/2),
                y3 = 0f
            )


            close()
        }


        return Outline.Generic(bezierShape)

    }
}