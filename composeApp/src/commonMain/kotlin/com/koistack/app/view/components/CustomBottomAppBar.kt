package com.koistack.app.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import androidx.compose.ui.unit.sp
import com.koistack.app.utils.ColorTheme
import com.koistack.app.utils.CutOutShape
import com.koistack.app.utils.Measurements
import com.koistack.app.utils.Navigation

///CONSTANTS

val COLOR_THEME = ColorTheme
val NAVIGATION = Navigation


@Composable
fun BoxScope.CustomBottomAppBar(
    navItem1: Pair<String, ImageVector>,
    navItem2: Pair<String, ImageVector>,
    navItem3: Pair<String, ImageVector>,
    navItem4: Pair<String, ImageVector>,
    navItemIconSize: Dp,
    navItemFontSize: TextUnit,
    buttonSize: Dp,
    bottomPadding: Dp
) {

    val measurements = Measurements.get()
    val safeBottomPadding = measurements.safeContentPaddingBottom / 2

    //This BottomNavBar is expected to sit inside of a Box Layout
    //Thus the very first modification is to align it BottomCentre!
    Box(
        modifier = Modifier
            .align(Alignment.BottomCenter)
            .fillMaxWidth(),
        contentAlignment = Alignment.TopCenter
    ) {

        // Row with NavItems in it
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(
                    minHeight = buttonSize
                )
                .height(IntrinsicSize.Min)
                .clip(shape = CutOutShape(buttonSize))
                .border(
                    width = Dp.Hairline,
                    shape = CutOutShape(buttonSize),
                    color = COLOR_THEME.border
                )
                .background(color = COLOR_THEME.topBackground)

                //Because the Row's height is based on the buttonSize
                //Have to add padding accordingly if the button is too small
                //Ensures navItems, don't touches the bottom navigation buttons
                .padding(
                    bottom = bottomPadding
                )

        ) {

            NavItem(
                itemTitleToIcon = navItem1,
                iconSize = navItemIconSize,
                fontSize = navItemFontSize
            )
            NavItem(
                itemTitleToIcon = navItem2,
                iconSize = navItemIconSize,
                fontSize = navItemFontSize
            )

            Spacer(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(color = COLOR_THEME.topBackground)
            )

            NavItem(
                itemTitleToIcon = navItem3,
                iconSize = navItemIconSize,
                fontSize = navItemFontSize
            )
            NavItem(
                itemTitleToIcon = navItem4,
                iconSize = navItemIconSize,
                fontSize = navItemFontSize

            )
        }

        //Floating Action Button
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .offset(y = -buttonSize / 2)
                .size(buttonSize)
                .clip(CircleShape)
                .border(
                    width = Dp.Hairline,
                    shape = CircleShape,
                    color = COLOR_THEME.border
                )
                .background(color = COLOR_THEME.mainAccentColor)
                .clickable(
                    onClick = {
                        TODO(
                            "Add Task addition Screen"
                        )
                    }
                )

        ) {
            Image(
                imageVector = Icons.Default.Add,
                contentDescription = null,
                colorFilter = ColorFilter.tint(COLOR_THEME.text),
                modifier = Modifier
                    .fillMaxSize(0.8f),
            )
        }


    }
}


@Composable
private fun RowScope.NavItem(
    itemTitleToIcon: Pair<String, ImageVector>,
    iconSize: Dp,
    fontSize: TextUnit
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .weight(1f)
            .fillMaxHeight()
            .background(color = COLOR_THEME.topBackground)
            .clickable(
                indication = null,
                interactionSource = null,
                onClick = {
                    NAVIGATION.setNewPosition(itemTitleToIcon.first)
                }
            )
    ) {

        Image(
            imageVector = itemTitleToIcon.second,
            contentDescription = null,
            colorFilter = ColorFilter.tint(COLOR_THEME.text),
            modifier = Modifier
                .size(iconSize)
                .fillMaxSize()
                .padding(
                    min(
                        a = iconSize / 10,
                        b = 10.dp
                    )
                )
        )

        Text(
            text = itemTitleToIcon.first,
            fontSize = fontSize,
            color = COLOR_THEME.text
        )

    }

}