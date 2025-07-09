package com.koistack.app.model.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.koistack.app.model.local.entities.SubTask
import com.koistack.app.model.local.entities.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface SubTaskDao {

    @Upsert
    suspend fun upsertSubTask(item: SubTask)

    @Delete
    suspend fun deleteSubTask(item: SubTask)

    @Query("SELECT * FROM SubTask WHERE SubTaskId = :subTaskId")
    suspend fun getSubTaskById(subTaskId: Int): SubTask

    @Query("SELECT * FROM SubTask")
    fun getAllSubTasks(): Flow<List<SubTask>>

    @Query("SELECT * FROM SubTask WHERE subTaskTitle = :subTaskTitle")
    fun getListOfSubTasksByTitle(subTaskTitle: String): Flow<List<SubTask>>

}
