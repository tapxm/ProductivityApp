package com.koistack.app.model.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.koistack.app.model.local.entities.Category
import com.koistack.app.model.local.entities.SubTask
import com.koistack.app.model.local.entities.Task
import kotlinx.coroutines.flow.Flow


@Dao
interface TaskDao {

    @Upsert
    suspend fun upsertTask(item: Task)

    @Delete
    suspend fun deleteTask(item: Task)

    @Query("SELECT * FROM Task WHERE taskId = :taskId")
    suspend fun getTaskById(taskId: Int): Task

    @Query("SELECT * FROM Task")
    fun getAllTasks(): Flow<List<Task>>

    @Query("SELECT * FROM Task WHERE taskTitle = :taskTitle")
    fun getListOfTasksByTitle(taskTitle: String): Flow<List<Task>>

    @Query("SELECT * FROM SubTask WHERE taskId = :taskId")
    fun getAllSubTasksInTask(taskId: Int): Flow<List<SubTask>>

}