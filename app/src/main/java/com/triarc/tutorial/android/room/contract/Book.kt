package com.triarc.tutorial.android.room.contract

import com.triarc.tutorial.android.room.base.BasePresenter
import com.triarc.tutorial.android.room.base.BaseView
import com.triarc.tutorial.android.room.entity.Book

/**
 * Created by Devanshu Verma on 19/1/19
 */
interface Book {
    interface View: BaseView {
        fun onBookSaved()
        fun onUpdateView(books: List<Book>?)
        fun onBookDeleted(book: Book)
        fun onInvalidInput(message: String)
        fun onInitialiseView()
        fun onInitialiseAdapter()
        fun onInitialiseListener()
    }

    interface Model {
        fun saveBook(book: Book)
        fun deleteBook(book: Book)
        fun getExistingBooks(): List<Book>?
        fun getBookByMatchingTitle(name: String): List<Book>?
    }

    interface Presenter: BasePresenter<View> {
        fun saveBook(name: String?, author: String?, publication: String?)
        fun deleteBook(book: Book?)
        fun getExistingBooks()
    }

    interface Repository {
        fun saveBook(book: Book)
        fun deleteBook(book: Book)
        fun getExistingBooks(): List<Book>?
        fun getBookByMatchingTitle(name: String): List<Book>?
    }
}
