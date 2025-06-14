package com.koistack.app.model

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.datetime.*


data class Task(
    val id: Int,
    var title: String?,
    var description: String?,
    var dueDate: Instant,
    var symbol: ImageVector,
    var status: String
)