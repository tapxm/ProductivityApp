package com.koistack.app.model.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

//Added foreign key to map the 1-to-Many relationship of Task-to-subTask

@Entity (
    foreignKeys = [
        ForeignKey(
            entity = Task::class,
            parentColumns = arrayOf("taskId"),
            childColumns = arrayOf("taskId"),
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE,
            )
    ]
)
data class SubTask (
    @PrimaryKey (autoGenerate = true)
    val subTaskId: Int = 0,

    var subTaskTitle: String,

    /*Our Foreign Key (taskId) is linked to a Task object*/
    /*Added @ColumnInfo(index = true) - as this is references taskId in Task table as a foreign key
    So full table scans aren't triggered whenever the parent table changes*/
    @ColumnInfo(index = true)
    val taskId: Int,

    var subTaskIsDone: Boolean = false,
)