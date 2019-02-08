package com.triarc.tutorial.android.room.presenter

import android.text.TextUtils
import com.triarc.tutorial.android.room.base.AbstractBasePresenter
import com.triarc.tutorial.android.room.contract.User
import com.triarc.tutorial.android.room.entity.User as UserEntity

/**
 * Created by Devanshu Verma on 13/1/19
 */
class UserPresenter(private val model: User.Model): AbstractBasePresenter<User.View>(), User.Presenter  {

    override fun attachView(view: User.View) {
        super.attachView(view)
        view.onInitialiseView()
        view.onInitialiseAdapter()
        view.onInitialiseListener()
    }

    override fun saveUser(name: String?, email: String?, school: String?, grade: String?) {
        if(name == null || TextUtils.isEmpty(name))
            getView()?.onInvalidInput("Invalid input, title can not be null")
        else if(email == null || TextUtils.isEmpty(email))
            getView()?.onInvalidInput("Invalid input, email can not be null")
        else if(school == null || TextUtils.isEmpty(school))
            getView()?.onInvalidInput("Invalid input, school can not be null")
        else if(grade == null || TextUtils.isEmpty(grade))
            getView()?.onInvalidInput("Invalid input, grade can not be null")
        else {
            model.saveUser(UserEntity(name, email, school, grade))
            getView()?.onUserSaved()
            getView()?.onUpdateView(model.getExistingUsers())
        }
    }

    override fun deleteUser(user: UserEntity?) {
        if(user != null) {
            model.deleteUser(user)
            getView()?.onUserDeleted(user)
            getView()?.onUpdateView(model.getExistingUsers())
        }
    }

    override fun getExistingUsers() {
        getView()?.onUpdateView(model.getExistingUsers())
    }
}
