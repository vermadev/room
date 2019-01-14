package com.triarc.tutorial.android.room.presenter

import android.text.TextUtils
import com.triarc.tutorial.android.room.base.AbstractBasePresenter
import com.triarc.tutorial.android.room.contract.UserList
import com.triarc.tutorial.android.room.entity.User

/**
 * Created by Devanshu Verma on 13/1/19
 */
class UserListPresenter(private val model: UserList.Model): AbstractBasePresenter<UserList.View>(), UserList.Presenter  {

    override fun attachView(view: UserList.View) {
        super.attachView(view)
        view.onInitialiseView()
        view.onInitialiseAdapter()
        view.onInitialiseListener()
    }

    override fun saveUser(name: String?) {
        if(name == null)
            getView()?.onInvalidInput("Invalid input, name can not be null")
        else {
            if(TextUtils.isEmpty(name)) {
                getView()?.onInvalidInput("Invalid input, name can not be empty")
            } else {
                model.saveUser(User(name))
                getView()?.onUserSaved()
                getView()?.onUpdateView(model.getUsers())
            }
        }
    }

    override fun getExistingUsers() {
        getView()?.onUpdateView(model.getUsers())
    }
}
