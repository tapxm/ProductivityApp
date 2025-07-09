package com.koistack.app.model.local

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.room.TypeConverters
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.koistack.app.model.local.dao.CategoryDao
import com.koistack.app.model.local.dao.SubTaskDao
import com.koistack.app.model.local.dao.TaskDao
import com.koistack.app.model.local.entities.Category
import com.koistack.app.model.local.entities.SubTask
import com.koistack.app.model.local.entities.Task
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

@Database(entities = [Task::class, Category::class, SubTask::class], version = 1)
@ConstructedBy(ProductivityAppDatabaseConstructor::class)
abstract class ProductivityAppDatabase : RoomDatabase() {
    abstract fun getTaskDao(): TaskDao
    abstract fun getCategoryDao(): CategoryDao
    abstract fun getSubTaskDao(): SubTaskDao
}

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object ProductivityAppDatabaseConstructor : RoomDatabaseConstructor<ProductivityAppDatabase> {
    override fun initialize(): ProductivityAppDatabase
}

fun getProductivityAppDatabase(
    builder: RoomDatabase.Builder<ProductivityAppDatabase>
): ProductivityAppDatabase {
    return builder
        .addMigrations()
        .fallbackToDestructiveMigrationOnDowngrade(true)
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}


expect fun getDatabaseBuilder():RoomDatabase.Builder<ProductivityAppDatabase>
