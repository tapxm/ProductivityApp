package com.koistack.app.model.repository

import com.koistack.app.model.local.ProductivityAppDatabase
import com.koistack.app.model.local.entities.Category
import com.koistack.app.model.local.entities.Task
import kotlinx.coroutines.flow.Flow

class CategoryRepository(database: ProductivityAppDatabase) {

    private val categoryDao = database.getCategoryDao()

    //CRUD

    //    Create
    suspend fun createCategory(
        categoryTitle: String,
        categoryDescription: String? = null,
        categoryImageName: String? = null,
    ) {

        val categoryToAdd = Category(
            categoryTitle = categoryTitle,
            categoryDescription = categoryDescription,
        )

        categoryImageName?.let {
            categoryToAdd.categoryImageName = categoryImageName
        }

        categoryDao.upsertCategory(categoryToAdd)
    }

    //    Read
    suspend fun getCategoryById(
        categoryId: Int,
    ): Category {
        return categoryDao.getCategoryById(categoryId)
    }

    fun getCategoriesByTitle(
        categoryTitle: String,
    ): Flow<List<Category>> {
        return categoryDao.getListOfCategoriesByTitle(categoryTitle)
    }

    fun getAllCategories(): Flow<List<Category>> {
        return categoryDao.getAllCategories()
    }

    fun getAllTasksInCategory(categoryId: Int): Flow<List<Task>> {
        return categoryDao.getAllTasksInCategory(categoryId)
    }

    //    Update
    suspend fun updateCategory(
        categoryId: Int,
        categoryTitle: String? = null,
        categoryDescription: String? = null,
        categoryImageName: String? = null,
        categoryIsDone: Boolean? = null
    ) {
        val categoryToUpdate = categoryDao.getCategoryById(categoryId)

        if (categoryTitle != null) {
            categoryToUpdate.categoryTitle = categoryTitle
        }
        if (categoryDescription != null) {
            categoryToUpdate.categoryDescription = categoryDescription
        }
        if (categoryImageName != null) {
            categoryToUpdate.categoryImageName = categoryImageName
        }
        if (categoryIsDone != null) {
            categoryToUpdate.categoryIsDone = categoryIsDone
        }

    }

    //    Delete
    suspend fun deleteCategory(categoryId: Int) {
        //Only delete if not the default category whose ID is 0
        if (categoryId != 0) {
            val categoryToDelete = categoryDao.getCategoryById(categoryId)
            categoryDao.deleteCategory(categoryToDelete)
        }
    }

}