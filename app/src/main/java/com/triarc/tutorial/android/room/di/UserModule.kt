package com.triarc.tutorial.android.room.di

import com.triarc.tutorial.android.room.contract.User
import com.triarc.tutorial.android.room.model.UserModel
import com.triarc.tutorial.android.room.presenter.UserPresenter
import com.triarc.tutorial.android.room.repository.UserRepository
import com.triarc.tutorial.android.room.storage.dao.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Devanshu Verma on 13/1/19
 */
@Module
class UserModule {

    @Provides
    @Singleton
    fun provideUserModel(repository: User.Repository): User.Model = UserModel(repository)

    @Provides
    @Singleton
    fun provideUserPresenter(model: User.Model): User.Presenter = UserPresenter(model)

    @Provides
    @Singleton
    fun provideUserRepository(userDao: UserDao): User.Repository = UserRepository(userDao)
}
