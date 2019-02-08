package com.triarc.tutorial.android.room.contract

import android.view.MenuItem
import com.triarc.tutorial.android.room.base.BasePresenter
import com.triarc.tutorial.android.room.base.BaseView
import com.triarc.tutorial.android.room.entity.Book
import com.triarc.tutorial.android.room.entity.Entries
import com.triarc.tutorial.android.room.entity.Register
import com.triarc.tutorial.android.room.entity.User
import com.triarc.tutorial.android.room.ipc.EventBus

/**
 * Created by Devanshu Verma on 21/1/19
 */
interface IssueBook {
    interface View: BaseView {
        fun onBookSelected(book: Book, users: List<User>?)
        fun onInitialiseView()
        fun onInitialiseListener()
        fun onOptionsMenuSelected(id: Int)
    }

    interface Model {
        fun getUsers(): List<User>?
        fun addEntriesToRegister(entries: List<Register>)
        fun getEntriesFromRegister(): List<Entries>?
    }

    interface Presenter: BasePresenter<View> {
        fun selectBook(book: Book)
        fun registerEventBus(listener: EventBus.Listener, vararg events: String)
        fun unRegisterEventBus()
        fun optionsMenuSelected(item: MenuItem?)
        fun addEntriesToRegister(entries: List<Register>)
    }
}
