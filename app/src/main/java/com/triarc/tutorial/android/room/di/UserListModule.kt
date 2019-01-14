package com.triarc.tutorial.android.room.di

import com.triarc.tutorial.android.room.contract.UserList
import com.triarc.tutorial.android.room.model.UserListModel
import com.triarc.tutorial.android.room.presenter.UserListPresenter
import com.triarc.tutorial.android.room.repository.UserListRepository
import com.triarc.tutorial.android.room.storage.dao.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Devanshu Verma on 13/1/19
 */
@Module
class UserListModule {

    @Provides
    @Singleton
    fun provideUserListModel(repository: UserList.Repository): UserList.Model = UserListModel(repository)

    @Provides
    @Singleton
    fun provideUserListPresenter(model: UserList.Model): UserList.Presenter = UserListPresenter(model)

    @Provides
    @Singleton
    fun provideUserListRepository(userDao: UserDao): UserList.Repository = UserListRepository(userDao)
}
