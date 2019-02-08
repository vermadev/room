package com.triarc.tutorial.android.room.presenter

import android.view.MenuItem
import com.triarc.tutorial.android.room.base.AbstractBasePresenter
import com.triarc.tutorial.android.room.contract.IssueBook
import com.triarc.tutorial.android.room.entity.Book
import com.triarc.tutorial.android.room.entity.Register
import com.triarc.tutorial.android.room.ipc.EventBus

/**
 * Created by Devanshu Verma on 30/1/19
 */
class IssueBookPresenter(private val model: IssueBook.Model): AbstractBasePresenter<IssueBook.View>(), IssueBook.Presenter {

    private var eventBus: EventBus? = null

    override fun attachView(view: IssueBook.View) {
        super.attachView(view)
        view.onInitialiseView()
        view.onInitialiseListener()
    }

    override fun selectBook(book: Book) {
        val users = model.getUsers()
        getView()?.onBookSelected(book, users)
    }

    override fun registerEventBus(listener: EventBus.Listener, vararg events: String) {
        getContext()?.let {context ->
            eventBus = EventBus(context, listener)
            events.forEach {event ->
                eventBus?.attach(event)
            }
        }
    }

    override fun unRegisterEventBus() {
        eventBus?.detach()
    }

    override fun optionsMenuSelected(item: MenuItem?) {
        getView()?.onOptionsMenuSelected(item?.itemId ?: 0)
    }

    override fun addEntriesToRegister(entries: List<Register>) {
        if(entries.isNotEmpty()) {
            model.addEntriesToRegister(entries)
            val entries = model.getEntriesFromRegister()
            logger.info("Found ${entries?.size} entries in register")
            entries?.forEach {
                logger.info("${it.name} has issued ${it.title}")
            }
        }
        else
            ;
    }
}
