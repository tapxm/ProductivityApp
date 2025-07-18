package com.koistack.app.model.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Ignore
import androidx.room.PrimaryKey
import productivityapp.composeapp.generated.resources.Res
import productivityapp.composeapp.generated.resources.default_category_image
import productivityapp.composeapp.generated.resources.default_category_title


//Added foreign key to map the 1-to-Many relationship of Category-to-Task

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Category::class,
            parentColumns = arrayOf("categoryId"),
            childColumns = arrayOf("categoryId"),
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE,
            )
    ]
)
data class Task(
    @PrimaryKey(autoGenerate = true)
    val taskId: Int = 0,

    var taskTitle: String,

    var taskDescription: String? = null,

    var taskDueDate: String = "today",

    @ColumnInfo(index = true)/*Added (as this is references taskId in Task table as a foreign key)
    So full table scans aren't triggered whenever the parent table changes*/
    /*Our Foreign Key (categoryId) is linked to a Category object - can be null because a task can exist without a category*/
    var categoryId: Int? = null,

    var categoryTitle: String? = null,

    var categoryImageName: String = Res.string.default_category_image.toString(),

    var taskIsDone: Boolean = false,
//    @Ignore
//    var listOfSubTasks: List<SubTask> = emptyList() /*not in schema as conversion is long*/
)
