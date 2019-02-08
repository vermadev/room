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
            .homeModule(HomeModule())
            .userModule(UserModule())
            .bookModule(BookModule())
            .searchModule(SearchModule())
            .databaseModule(DatabaseModule())
            .issueBookModule(IssueBookModule())
            .applicationContextModule(ApplicationContextModule(this))
            .build()
    }

    fun getApplicationComponent() = applicationComponent
}
