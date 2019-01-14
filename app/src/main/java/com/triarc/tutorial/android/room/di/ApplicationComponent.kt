package com.triarc.tutorial.android.room.di

import com.triarc.tutorial.android.room.view.NameListFragment
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Devanshu Verma on 13/1/19
 */
@Singleton
@Component(modules = [UserListModule::class, DatabaseModule::class, ApplicationContextModule::class])
interface ApplicationComponent {

    fun inject(target: NameListFragment)
}
