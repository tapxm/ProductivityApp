package com.koistack.app.model.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.getResourceUri
import productivityapp.composeapp.generated.resources.Res
import productivityapp.composeapp.generated.resources.image

@Entity
data class Category(
    @PrimaryKey(autoGenerate = true)
    val categoryId: Int = 0,

    var categoryTitle: String = "DEFAULT",

    var categoryDescription: String? = null,

    var categoryImageName: String = "image.png",

    var categoryIsDone: Boolean = false,
//    @Ignore
//    val listOfTasks: List<Task> = arrayListOf()/*not in schema as conversion is long*/
)


