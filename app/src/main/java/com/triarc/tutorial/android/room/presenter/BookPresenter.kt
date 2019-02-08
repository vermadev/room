package com.triarc.tutorial.android.room.presenter

import android.text.TextUtils
import com.triarc.tutorial.android.room.base.AbstractBasePresenter
import com.triarc.tutorial.android.room.contract.Book
import com.triarc.tutorial.android.room.entity.Book as BookEntity

/**
 * Created by Devanshu Verma on 13/1/19
 */
class BookPresenter(private val model: Book.Model): AbstractBasePresenter<Book.View>(), Book.Presenter  {

    override fun attachView(view: Book.View) {
        super.attachView(view)
        view.onInitialiseView()
        view.onInitialiseAdapter()
        view.onInitialiseListener()
    }

    override fun saveBook(name: String?, author: String?, publication: String?) {
        if(name == null || TextUtils.isEmpty(name))
            getView()?.onInvalidInput("Invalid input, title can not be null")
        else if(author == null || TextUtils.isEmpty(author))
            getView()?.onInvalidInput("Invalid input, author can not be null")
        else if(publication == null || TextUtils.isEmpty(publication))
            getView()?.onInvalidInput("Invalid input, publication can not be null")
        else {
            model.saveBook(BookEntity(name, author, publication))
            getView()?.onBookSaved()
            getView()?.onUpdateView(model.getExistingBooks())
        }
    }

    override fun deleteBook(book: BookEntity?) {
        if(book != null) {
            model.deleteBook(book)
            getView()?.onBookDeleted(book)
            getView()?.onUpdateView(model.getExistingBooks())
        }
    }

    override fun getExistingBooks() {
        getView()?.onUpdateView(model.getExistingBooks())
    }
}
