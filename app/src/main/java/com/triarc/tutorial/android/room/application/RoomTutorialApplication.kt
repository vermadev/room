package com.triarc.tutorial.android.room.application

import android.app.Application
import com.triarc.tutorial.android.room.di.*

/**
 * Created by Devanshu Verma on 13/1/19
 */
class RoomTutorialApplication: Application() {

    private lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent
            .builder()
            .userListModule(UserListModule())
            .databaseModule(DatabaseModule())
            .applicationContextModule(ApplicationContextModule(this))
            .build()
    }

    fun getApplicationComponent() = applicationComponent
}
