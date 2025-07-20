package com.koistack.app.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.koistack.app.controller.RepositoryProvider
import com.koistack.app.model.repository.TaskRepository
import com.koistack.app.utils.ColorTheme
import com.koistack.app.utils.Measurements
import com.koistack.app.utils.Navigation
import com.koistack.app.view.components.CustomBottomAppBar
import com.koistack.app.view.pages.CalenderPage
import com.koistack.app.view.pages.CreateTaskDialog
import com.koistack.app.view.pages.OverviewPage
import com.koistack.app.view.pages.SettingsPage
import com.koistack.app.view.pages.TaskListPage

//THEME AND Navigational Constants
val COLOR_THEME = ColorTheme
val NAVIGATION = Navigation

//BOTTOM APPLICATION BAR CONSTANTS
val APP_BAR_MIDDLE_BUTTON_SIZE = 50.dp

val APP_BAR_NAV_ITEM_ICON_SIZE = 35.dp

val APP_BAR_NAV_ITEM_FONT_SIZE = 10.sp

@Composable
fun MainScreen() {

    val createTaskRequested = remember { mutableStateOf(false) }

    val measurements = Measurements.get()

    val bottomPadding = measurements.safeContentPaddingBottom

    val bottomAppBarHeight = (
            bottomPadding.value
                    + APP_BAR_NAV_ITEM_FONT_SIZE.value
                    + APP_BAR_NAV_ITEM_ICON_SIZE.value
                    + APP_BAR_MIDDLE_BUTTON_SIZE.value * 0.5f
            ).dp


    //Box Holding everything fills entire Screen
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = COLOR_THEME.bottomBackground)
    ) {
        mainScreenContent(
            bottomAppBarHeight
        )

        CustomBottomAppBar(
            navItem1 = "overview" to Icons.Default.Home,
            navItem2 = "tasks" to Icons.Default.Done,
            navItem3 = "calender" to Icons.Default.Notifications,
            navItem4 = "settings" to Icons.Default.Settings,
            navItemIconSize = APP_BAR_NAV_ITEM_ICON_SIZE,
            navItemFontSize = APP_BAR_NAV_ITEM_FONT_SIZE,
            buttonSize = APP_BAR_MIDDLE_BUTTON_SIZE,
            bottomPadding = bottomPadding,
            onButtonClick = {
                createTaskRequested.value = true
            }
        )

        if (createTaskRequested.value) {
            CreateTaskDialog(createTaskRequested)
        }

    }

}


@Composable
fun mainScreenContent(bottomAppBarHeight: Dp) {
    val currentLocation = NAVIGATION.currentPosition

    val taskRepository: TaskRepository = RepositoryProvider.taskRepository

    val taskListFlow = taskRepository.getAllTasks()

    val taskList by taskListFlow.collectAsStateWithLifecycle(initialValue = emptyList())

    Column(
        modifier = Modifier
            .padding(top = WindowInsets.safeContent.asPaddingValues().calculateTopPadding())
    ) {
        when (currentLocation) {
            "tasks" -> TaskListPage(bottomAppBarHeight, taskList = taskList)
            "overview" -> OverviewPage(bottomAppBarHeight)
            "calender" -> CalenderPage(bottomAppBarHeight)
            "settings" -> SettingsPage(bottomAppBarHeight)
        }
    }
}