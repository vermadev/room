package com.triarc.tutorial.android.room.storage

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.triarc.tutorial.android.room.di.DatabaseModule
import com.triarc.tutorial.android.room.entity.Book
import com.triarc.tutorial.android.room.entity.Register
import com.triarc.tutorial.android.room.entity.User
import com.triarc.tutorial.android.room.storage.dao.BookDao
import com.triarc.tutorial.android.room.storage.dao.RegisterDao
import com.triarc.tutorial.android.room.storage.dao.UserDao

/**
 * Created by Devanshu Verma on 14/1/19
 */
@Database(entities = [User::class, Book::class, Register::class], version = DatabaseModule.Database.VERSION)
abstract class RoomTutorialDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun bookDao(): BookDao
    abstract fun registerDao(): RegisterDao
}
