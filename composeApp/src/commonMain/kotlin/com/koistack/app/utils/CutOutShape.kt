package com.koistack.app.utils

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import kotlin.math.max
import kotlin.math.min

class CutOutShape(
    private val expectedElementSize: Dp
) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {

        val expectedElementSizeInPx = with(density) { expectedElementSize.toPx() }

        //THIS WILL CREATE THE GAP BETWEEN THE CUTOUT AND THE ELEMENT IT EXPECTS
        //THUS SHOULD NOT EXCEED 20.Dp
        val requiredGapSize =
            min(
                a = expectedElementSizeInPx * 0.2f,
                b = with(density) { 20.dp.toPx() }
            )


        //The cutout have a gap of 10.Dp or 10% (Whichever is smaller) on both sides,
        //As it's circular the gap added is actually divided by two
        val cutOutWidth = expectedElementSizeInPx + (requiredGapSize)

        //Cutout height is just half of the cutOutWidth as we want a Circular Shape
        val cutOutHeight = cutOutWidth / 2


        //THIS WILL CREATE THE Distance From the Flat top of surface to curve of cutout
        //Experimented but its most visually appealing at around 1/4th the cutout's width
        val topEdgeDistance = cutOutWidth * 0.25f


        //CHECK THAT THE CUTOUT WIDTH DOES NOT EXCEED THE AVAILABLE WIDTH
        val cutOutExceedsAvailableWidth: Boolean =
            (cutOutWidth >= size.width)

        //CHECK THAT THE CUTOUT HEIGHT DOES NOT EXCEED HALF THE AVAILABLE HEIGHT
        val cutOutExceedsAvailableHeightMidpoint: Boolean =
            (cutOutHeight > size.width)


        val bezierShape = Path().apply {

            //Start at point after "CUT-OUT"
            moveTo(
                x = (size.width / 2) + cutOutWidth / 2 + topEdgeDistance,
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
                x = (size.width / 2) - cutOutWidth / 2 - topEdgeDistance,
                y = 0f
            )

            cubicTo(
                //First Control coordinates
                x1 = (size.width / 2) - cutOutWidth / 2,
                y1 = 0f,

                //Second Control coordinates
                x2 = (size.width / 2) - cutOutWidth / 2 ,
                y2 = cutOutHeight,

                //End Point coordinates
                x3 = size.width / 2,
                y3 = cutOutHeight
            )

            cubicTo(

                //First Control coordinates
                x1 = (size.width / 2) + cutOutWidth/2,
                y1 = cutOutHeight,

                //Second Control coordinates
                x2 = (size.width / 2) + cutOutWidth/2,
                y2 = 0f,

                //Final Point coordinates
                x3 = (size.width / 2) + cutOutWidth/2 + topEdgeDistance,
                y3 = 0f
            )

            close()
        }

        return Outline.Generic(bezierShape)

    }

}