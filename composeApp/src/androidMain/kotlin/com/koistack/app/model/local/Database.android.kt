package com.koistack.app.model.local

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.koistack.app.MyApp

actual fun getDatabaseBuilder() :RoomDatabase.Builder<ProductivityAppDatabase> {
    val ctx: Context = MyApp.instance
    val dbFile = ctx.getDatabasePath("productivity_app_room.db")
    return Room.databaseBuilder<ProductivityAppDatabase>(
        context = ctx,
        name = dbFile.absolutePath
    )
}
