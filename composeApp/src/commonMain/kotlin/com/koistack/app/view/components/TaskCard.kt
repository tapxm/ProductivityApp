package com.koistack.app.view.components

import androidx.annotation.RestrictTo
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.koistack.app.controller.Controller
import com.koistack.app.model.local.entities.Category
import com.koistack.app.model.local.entities.Task
import com.koistack.app.utils.ColorTheme
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import productivityapp.composeapp.generated.resources.Res
import productivityapp.composeapp.generated.resources.allDrawableResources
import productivityapp.composeapp.generated.resources.default
import productivityapp.composeapp.generated.resources.image


@OptIn(ExperimentalResourceApi::class)
@Composable
fun taskCard(){}