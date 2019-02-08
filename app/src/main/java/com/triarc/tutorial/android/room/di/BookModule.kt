package com.triarc.tutorial.android.room.di

import com.triarc.tutorial.android.room.contract.Book
import com.triarc.tutorial.android.room.contract.User
import com.triarc.tutorial.android.room.model.BookModel
import com.triarc.tutorial.android.room.model.UserModel
import com.triarc.tutorial.android.room.presenter.BookPresenter
import com.triarc.tutorial.android.room.presenter.UserPresenter
import com.triarc.tutorial.android.room.repository.BookRepository
import com.triarc.tutorial.android.room.repository.UserRepository
import com.triarc.tutorial.android.room.storage.dao.BookDao
import com.triarc.tutorial.android.room.storage.dao.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Devanshu Verma on 13/1/19
 */
@Module
class BookModule {

    @Provides
    @Singleton
    fun provideUserModel(repository: Book.Repository): Book.Model = BookModel(repository)

    @Provides
    @Singleton
    fun provideUserPresenter(model: Book.Model): Book.Presenter = BookPresenter(model)

    @Provides
    @Singleton
    fun provideUserRepository(bookDao: BookDao): Book.Repository = BookRepository(bookDao)
}
