package com.droid.clean_architecture_android_tutorial.data.database.room

import android.content.Context
import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.droid.clean_architecture_android_tutorial.data.beans.Post
import android.icu.lang.UCharacter.GraphemeClusterBreak.V
import androidx.room.Room
import android.icu.lang.UCharacter.GraphemeClusterBreak.V


@Database(entities = arrayOf(Post::class), version = 1)
abstract class AppDataBase : RoomDatabase() {

    val DATABASE_NAME = "app_db"

    private var instance: AppDataBase? = null

    fun getInstance(context: Context): AppDataBase {
        if (instance == null) {
            instance = Room.databaseBuilder(
                context.getApplicationContext(),
                AppDataBase::class.java,
                DATABASE_NAME
            ).build()
        }
        return instance as AppDataBase
    }


    //abstract fun getAppDaa() : AppDao


}