package com.koistack.app.controller

import com.koistack.app.model.local.ProductivityAppDatabase
import com.koistack.app.model.repository.CategoryRepository
import com.koistack.app.model.repository.SubTaskRepository
import com.koistack.app.model.repository.TaskRepository

class Controller(database: ProductivityAppDatabase) {

    val categoryRepo: CategoryRepository = CategoryRepository(database)

    val taskRepo: TaskRepository = TaskRepository(database)

    val subTaskRepo: SubTaskRepository = SubTaskRepository(database)

}
