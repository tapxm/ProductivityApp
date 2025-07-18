package com.koistack.app.model.repository

import com.koistack.app.model.local.ProductivityAppDatabase
import com.koistack.app.model.local.entities.SubTask
import com.koistack.app.model.local.entities.Task
import kotlinx.coroutines.flow.Flow
import productivityapp.composeapp.generated.resources.Res
import productivityapp.composeapp.generated.resources.default_category_image

//Handles the CRUD logic for tasks

class TaskRepository(database: ProductivityAppDatabase) {

    private val categoryDao = database.getCategoryDao()

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

        taskDueDate?.let {
            taskToAdd.taskDueDate = taskDueDate
        }

        categoryId?.let {

            val categoryForTask = categoryDao.getCategoryById(it)

            taskToAdd.categoryId = categoryForTask.categoryId

            taskToAdd.categoryTitle = categoryForTask.categoryTitle

            taskToAdd.categoryImageName = categoryForTask.categoryImageName

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
        taskIsDone: Boolean? = null,
        removeCategory: Boolean = false
    ) {
        val taskToUpdate = taskDao.getTaskById(taskId)

        taskTitle?.let {
            taskToUpdate.taskTitle = it
        }

        taskDescription?.let {
            taskToUpdate.taskDescription = it
        }

        taskDueDate?.let {
            taskToUpdate.taskDueDate = it
        }

        taskIsDone?.let {
            taskToUpdate.taskIsDone = it
        }

        categoryId?.let {

            val categoryForTask = categoryDao.getCategoryById(it)

            taskToUpdate.categoryId = it

            taskToUpdate.categoryTitle = categoryForTask.categoryTitle

            taskToUpdate.categoryImageName = categoryForTask.categoryImageName
        }

        if (removeCategory) {
            taskToUpdate.categoryId = null

            taskToUpdate.categoryTitle = null

            taskToUpdate.categoryImageName = Res.string.default_category_image.toString()
        }
    }

    //    Delete
    suspend fun deleteTask(taskId: Int) {
        val taskToDelete = taskDao.getTaskById(taskId)
        taskDao.deleteTask(taskToDelete)
    }

}
