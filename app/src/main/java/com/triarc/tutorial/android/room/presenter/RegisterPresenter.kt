package com.triarc.tutorial.android.room.presenter

import android.view.MenuItem
import com.triarc.tutorial.android.room.base.AbstractBasePresenter
import com.triarc.tutorial.android.room.contract.Register

/**
 * Created by Devanshu Verma on 15/1/19
 */
class RegisterPresenter(private val model: Register.Model): AbstractBasePresenter<Register.View>(), Register.Presenter {

    override fun attachView(view: Register.View) {
        super.attachView(view)
        view.onInitialiseView()
        view.onInitialiseAdapter()
        view.onInitialiseListener()
    }

    override fun updateRegister() {
        getView()?.onUpdateView(model.getEntriesFromRegister())
    }

    override fun optionsMenuSelected(item: MenuItem?) {
        if(item != null)
            getView()?.onOptionsMenuSelected(item.itemId)
    }
}
