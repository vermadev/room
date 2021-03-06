package com.triarc.tutorial.android.room.di

import android.app.Application
import android.arch.persistence.room.Room
import com.triarc.tutorial.android.room.storage.dao.UserDao
import com.triarc.tutorial.android.room.storage.RoomTutorialDatabase
import com.triarc.tutorial.android.room.storage.DatabaseMigrations
import com.triarc.tutorial.android.room.storage.dao.BookDao
import com.triarc.tutorial.android.room.storage.dao.RegisterDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Devanshu Verma on 14/1/19
 */
@Module
class DatabaseModule {

    object Database {
        const val NAME    = "room_tutorial_database.db"
        const val VERSION = 2
    }

    @Provides
    @Singleton
    fun provideDatabase(application: Application): RoomTutorialDatabase {
        return Room.databaseBuilder(application, RoomTutorialDatabase::class.java, Database.NAME)
            .allowMainThreadQueries()
            .addMigrations(*DatabaseMigrations.MIGRATION_LIST.toTypedArray())
            .build()
    }

    @Provides
    @Singleton
    fun provideUserDao(database: RoomTutorialDatabase): UserDao = database.userDao()

    @Provides
    @Singleton
    fun provideBookDao(database: RoomTutorialDatabase): BookDao = database.bookDao()

    @Provides
    @Singleton
    fun provideRegisterDao(database: RoomTutorialDatabase): RegisterDao = database.registerDao()
}
