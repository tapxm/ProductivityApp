package com.koistack.app.model.repository

import com.koistack.app.model.local.ProductivityAppDatabase
import com.koistack.app.model.local.entities.SubTask
import com.koistack.app.model.local.entities.Task
import kotlinx.coroutines.flow.Flow

class SubTaskRepository (database: ProductivityAppDatabase) {

    private val subTaskDao = database.getSubTaskDao()

    //CRUD

    //    Create
    suspend fun createSubTask(
        subTaskTitle: String,
        taskId: Int
    ) {
        val subTaskToAdd = SubTask(
            subTaskTitle = subTaskTitle,
            taskId = taskId
        )
        subTaskDao.upsertSubTask(subTaskToAdd)
    }

    //    Read
    suspend fun getSubTaskById(
        subTaskId: Int,
    ): SubTask {
        return subTaskDao.getSubTaskById(subTaskId)
    }

    fun getSubTasksByTitle(
        subTaskTitle: String,
    ): Flow<List<SubTask>> {
        return subTaskDao.getListOfSubTasksByTitle(subTaskTitle)
    }

    fun getAllSubTasks(): Flow<List<SubTask>> {
        return subTaskDao.getAllSubTasks()
    }


    //    Update
    suspend fun updateSubTask(
        subTaskId: Int,
        subTaskTitle: String? = null,
        subTaskIsDone: Boolean? = null
    ) {
        val subTaskToUpdate = subTaskDao.getSubTaskById(subTaskId)

        if (subTaskTitle != null) {
            subTaskToUpdate.subTaskTitle = subTaskTitle
        }
        if (subTaskIsDone != null) {
            subTaskToUpdate.subTaskIsDone = subTaskIsDone
        }

    }

    //    Delete
    suspend fun deleteSubTask(subTaskId: Int) {
        val subTaskToDelete = subTaskDao.getSubTaskById(subTaskId)
        subTaskDao.deleteSubTask(subTaskToDelete)
    }

}