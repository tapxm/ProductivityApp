package com.koistack.app.controller

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.koistack.app.model.Task
import kotlinx.datetime.Clock

class TaskController(
) {

    object TaskRepo {
        val taskList = mutableListOf<Task>();
    }

    val allTasks = TaskRepo.taskList;
    
    fun createTask(title: String?, description: String?){
        val newTask:Task = Task(
            id = allTasks.size,
            title = title,
            description = description,
            dueDate = Clock.System.now(),
            symbol = Icons.Filled.Home,
            status = "progressing"
        );

        allTasks.add(newTask);

    }

    fun getTask(title: String):Task?{
        return  allTasks.find { title == it.title }
    }

    fun getTasks() : List<Task>{
        return allTasks;
    }

    fun editTask(task: Task, newTitle: String?, newDesc: String?){
        task.title = newTitle;
        task.description = newDesc;
    }

    fun deleteTask(title: String){
        val taskToDelete = allTasks.find { title == it.title }
        allTasks.remove(taskToDelete)
    }
}