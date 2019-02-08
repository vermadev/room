package com.triarc.tutorial.android.room.contract

import android.view.MenuItem
import com.triarc.tutorial.android.room.base.BasePresenter
import com.triarc.tutorial.android.room.base.BaseView
import com.triarc.tutorial.android.room.entity.Entries
import com.triarc.tutorial.android.room.entity.Register

/**
 * Created by Devanshu Verma on 15/1/19
 */
interface Register {
    interface View: BaseView {
        fun onUpdateView(register: List<Entries>?)
        fun onInitialiseView()
        fun onInitialiseAdapter()
        fun onInitialiseListener()
        fun onOptionsMenuSelected(id: Int)
    }

    interface Model {
        fun getEntriesFromRegister(): List<Entries>?
    }

    interface Presenter: BasePresenter<View> {
        fun updateRegister()
        fun optionsMenuSelected(item: MenuItem?)
    }

    interface Repository {
        fun addEntryToRegister(register: Register)
        fun addEntriesToRegister(entries: List<Register>)
        fun getEntriesFromRegister(): List<Entries>?
        fun deleteEntryFromRegister(register: Register)
        fun updateEntryFromRegister(register: Register)
    }
}