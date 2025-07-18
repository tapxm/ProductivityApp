package com.koistack.app.controller

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import com.koistack.app.model.local.entities.Task
import com.koistack.app.model.repository.CategoryRepository
import com.koistack.app.utils.ColorTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TaskController: ViewModel() {

    private val taskRepository = RepositoryProvider.taskRepository


    suspend fun onLongPressDelete(task: Task){
        taskRepository.deleteTask(task.taskId)
    }

    fun onPressChangeTheme(){
        ColorTheme.setColorTheme(
            setToDarkMode = !ColorTheme.inDarkMode,
            setColorThemeHue = null
        )
    }

}