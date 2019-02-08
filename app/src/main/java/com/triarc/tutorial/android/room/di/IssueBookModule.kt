package com.triarc.tutorial.android.room.di

import com.triarc.tutorial.android.room.contract.IssueBook
import com.triarc.tutorial.android.room.contract.Register
import com.triarc.tutorial.android.room.contract.User
import com.triarc.tutorial.android.room.model.IssueBookModel
import com.triarc.tutorial.android.room.presenter.IssueBookPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Devanshu Verma on 27/1/19
 */
@Module
class IssueBookModule {

    @Provides
    @Singleton
    fun provideIssueBookModel(user: User.Repository, register: Register.Repository): IssueBook.Model = IssueBookModel(user, register)

    @Provides
    @Singleton
    fun provideIssueBookPresenter(model: IssueBook.Model): IssueBook.Presenter = IssueBookPresenter(model)
}
