package com.triarc.tutorial.android.room.di

import com.triarc.tutorial.android.room.contract.Register
import com.triarc.tutorial.android.room.model.RegisterModel
import com.triarc.tutorial.android.room.presenter.RegisterPresenter
import com.triarc.tutorial.android.room.repository.RegisterRepository
import com.triarc.tutorial.android.room.storage.dao.RegisterDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Devanshu Verma on 16/1/19
 */
@Module
class HomeModule {

    @Provides
    @Singleton
    fun provideHomeModel(repository: Register.Repository): Register.Model = RegisterModel(repository)

    @Provides
    @Singleton
    fun provideHomePresenter(model: Register.Model): Register.Presenter = RegisterPresenter(model)

    @Provides
    @Singleton
    fun provideHomeRepository(registerDao: RegisterDao): Register.Repository = RegisterRepository(registerDao)
}
