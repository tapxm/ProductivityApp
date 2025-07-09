package com.koistack.app.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/*A general reusable Navbar that highlights the clicked "NavItem"
* and returns the current/expected location
**/

@Composable
fun BottomNavBar(
    currentLocation: MutableState<String>,
    listOfNavItems: List<String>,
    content: @Composable ColumnScope.(String) -> Unit,
) {

    //This is the outer edge of the navigation bar
    Row(
        modifier = Modifier
            .padding(0.dp)
            .fillMaxWidth()
            .padding(
                bottom = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()
            ),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        //List of routes turned into columns
        // All pressable & direct you to the required page
        for (itemTextID in listOfNavItems) {
            NavItem(
                content = { content(itemTextID) },
                itemTextID = itemTextID,
                currentLocation = currentLocation,
            )
        }
    }
}


//Creates a navigational item based on the input data
//The RowScope interface allows the navItems to utilise the
//Modifier.weight of the future row composable they'll be added to
@Composable
private fun RowScope.NavItem(
    itemTextID: String,
    content: @Composable ColumnScope.() -> Unit,
    currentLocation: MutableState<String>
) {

    var navItemClicked by remember { mutableStateOf(false) }

    navItemClicked = (currentLocation.value == itemTextID)

    val backgroundColor = if (navItemClicked) Color.Red else Color.Blue

    Column(
        content = content,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(backgroundColor)
            .weight(1f)
            .clickable(
                onClick = {
                    println("the location was $currentLocation")

                    navItemClicked = true

                    currentLocation.value = itemTextID

                    println("the location has changed to $currentLocation")
                    println()
                }
            )
    )
}
