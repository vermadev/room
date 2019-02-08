package com.triarc.tutorial.android.room.di

import com.triarc.tutorial.android.room.contract.Book
import com.triarc.tutorial.android.room.contract.Search
import com.triarc.tutorial.android.room.presenter.SearchPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Devanshu Verma on 27/1/19
 */
@Module
class SearchModule {

    @Provides
    @Singleton
    fun provideSearchPresenter(model: Book.Model): Search.Presenter = SearchPresenter(model)
}
