package com.triarc.tutorial.android.room.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Devanshu Verma on 13/1/19
 */
@Module
class ApplicationContextModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Context = application

    @Provides
    @Singleton
    fun provideApplicationApplication(): Application = application
}
