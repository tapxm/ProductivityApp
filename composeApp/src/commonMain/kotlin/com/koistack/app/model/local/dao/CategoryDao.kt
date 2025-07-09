package com.koistack.app.model.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.koistack.app.model.local.entities.Category
import com.koistack.app.model.local.entities.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {

    @Upsert
    suspend fun upsertCategory(item: Category)

    @Delete
    suspend fun deleteCategory(item: Category)

    @Query("SELECT * FROM Category WHERE categoryId = :categoryId")
    suspend fun getCategoryById(categoryId: Int): Category

    @Query("SELECT * FROM Category")
    fun getAllCategories(): Flow<List<Category>>

    @Query("SELECT * FROM Category WHERE categoryTitle = :categoryTitle")
    fun getListOfCategoriesByTitle(categoryTitle: String): Flow<List<Category>>

    @Query("SELECT * FROM Task WHERE categoryID = :categoryId")
    fun getAllTasksInCategory(categoryId: Int): Flow<List<Task>>





}