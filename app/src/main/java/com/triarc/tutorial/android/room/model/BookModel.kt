package com.triarc.tutorial.android.room.model

import com.triarc.tutorial.android.room.contract.Book
import com.triarc.tutorial.android.room.entity.Book as BookEntity

/**
 * Created by Devanshu Verma on 13/1/19
 */
class BookModel(private val repository: Book.Repository): Book.Model {

    override fun saveBook(book: BookEntity) {
        repository.saveBook(book)
    }

    override fun deleteBook(book: BookEntity) {
        repository.deleteBook(book)
    }

    override fun getExistingBooks(): List<BookEntity>? = repository.getExistingBooks()

    override fun getBookByMatchingTitle(name: String): List<BookEntity>? = repository.getBookByMatchingTitle(name)
}
