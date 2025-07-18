package com.koistack.app.controller

import com.koistack.app.model.local.ProductivityAppDatabase
import com.koistack.app.model.local.getDatabaseBuilder
import com.koistack.app.model.local.getProductivityAppDatabase
import com.koistack.app.model.repository.CategoryRepository
import com.koistack.app.model.repository.SubTaskRepository
import com.koistack.app.model.repository.TaskRepository

object RepositoryProvider {

    private val database: ProductivityAppDatabase =
        getProductivityAppDatabase(
            getDatabaseBuilder()
        )

    val categoryRepository: CategoryRepository = CategoryRepository(database)

    val taskRepository: TaskRepository = TaskRepository(database)

    val subTaskRepository: SubTaskRepository = SubTaskRepository(database)

}
