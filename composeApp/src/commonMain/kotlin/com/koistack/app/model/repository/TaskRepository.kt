package com.koistack.app.model.repository

import com.koistack.app.model.local.ProductivityAppDatabase
import com.koistack.app.model.local.entities.SubTask
import com.koistack.app.model.local.entities.Task
import kotlinx.coroutines.flow.Flow

//Handles the CRUD logic for tasks

class TaskRepository(database: ProductivityAppDatabase) {

    private val taskDao = database.getTaskDao()

    //CRUD

    //    Create
    suspend fun createTask(
        taskTitle: String,
        taskDescription: String? = null,
        taskDueDate: String? = null,
        categoryId: Int? = null,
    ) {
        val taskToAdd = Task(
            taskTitle = taskTitle,
            taskDescription = taskDescription,
        )

        taskDueDate?.let{
            taskToAdd.taskDueDate = taskDueDate
        }

        categoryId?.let {
            taskToAdd.categoryId = categoryId
        }

        taskDao.upsertTask(taskToAdd)
    }

    //    Read
    suspend fun getTaskById(
        taskId: Int,
    ): Task {
        return taskDao.getTaskById(taskId)
    }

    fun getTasksByTitle(
        taskTitle: String,
    ): Flow<List<Task>> {
        return taskDao.getListOfTasksByTitle(taskTitle)
    }

    fun getAllTasks(): Flow<List<Task>> {
        return taskDao.getAllTasks()
    }

    fun getAllSubTasksInTask(taskId: Int): Flow<List<SubTask>> {
        return taskDao.getAllSubTasksInTask(taskId)
    }

    //    Update
    suspend fun updateTask(
        taskId: Int,
        taskTitle: String? = null,
        taskDescription: String? = null,
        taskDueDate: String? = null,
        categoryId: Int? = null,
        taskIsDone: Boolean? = null
    ) {
        val taskToUpdate = taskDao.getTaskById(taskId)

        if (taskTitle != null) {
            taskToUpdate.taskTitle = taskTitle
        }
        if (taskDescription != null) {
            taskToUpdate.taskDescription = taskDescription
        }
        if (taskDueDate != null) {
            taskToUpdate.taskDueDate = taskDueDate
        }
        if (categoryId != null) {
            taskToUpdate.categoryId = categoryId
        }
        if (taskIsDone != null) {
            taskToUpdate.taskIsDone = taskIsDone
        }

    }

    //    Delete
    suspend fun deleteTask(taskId: Int) {
        val taskToDelete = taskDao.getTaskById(taskId)
        taskDao.deleteTask(taskToDelete)
    }

}
