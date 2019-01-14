package com.triarc.tutorial.android.room.contract

import com.triarc.tutorial.android.room.base.BasePresenter
import com.triarc.tutorial.android.room.base.BaseView
import com.triarc.tutorial.android.room.entity.User

/**
 * Created by Devanshu Verma on 13/1/19
 */
interface UserList {
    interface View: BaseView {
        fun onUserSaved()
        fun onUpdateView(users: List<User>?)
        fun onInvalidInput(message: String)
        fun onInitialiseView()
        fun onInitialiseAdapter()
        fun onInitialiseListener()
    }

    interface Model {
        fun saveUser(user: User)
        fun getUsers(): List<User>?
    }

    interface Presenter: BasePresenter<View> {
        fun saveUser(name: String?)
        fun getExistingUsers()
    }

    interface Repository {
        fun saveUser(user: User)
        fun getUsers(): List<User>?
    }
}
