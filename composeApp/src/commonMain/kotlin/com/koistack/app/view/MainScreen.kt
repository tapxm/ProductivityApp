package com.koistack.app.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalViewConfiguration
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.dp
import com.koistack.app.utils.ColorTheme
import com.koistack.app.utils.Measurements
import com.koistack.app.utils.Navigation
import com.koistack.app.view.components.CustomBottomAppBar
import com.koistack.app.view.pages.CalenderPage
import com.koistack.app.view.pages.OverviewPage
import com.koistack.app.view.pages.SettingsPage
import com.koistack.app.view.pages.TaskListPage

val COLOR_THEME = ColorTheme
val NAVIGATION = Navigation

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MainScreen() {

    val measurements = Measurements.get()

    val bottomPadding = measurements.safeContentPaddingBottom/2

    //Box Holding everything fills entire Screen
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = COLOR_THEME.bottomBackground)
    ){
        mainScreenContent()

        CustomBottomAppBar(
            navItem1 = "overview" to Icons.Default.Home,
            navItem2 = "tasks" to Icons.Default.Done,
            navItem3 = "calender" to Icons.Default.Notifications,
            navItem4 = "settings" to Icons.Default.Settings,
            navItemIconSize = 30.dp,
            buttonSize = 50.dp,
            bottomPadding = bottomPadding
        )
    }

}


@Composable
fun mainScreenContent() {
    val currentLocation = Navigation.currentPosition

    Column(
        modifier = Modifier
            .padding(top = WindowInsets.safeContent.asPaddingValues().calculateTopPadding())
    ) {
        when (currentLocation) {
            "tasks" -> TaskListPage()
            "overview" -> OverviewPage()
            "calender" -> CalenderPage()
            "settings" -> SettingsPage()
        }
    }
}