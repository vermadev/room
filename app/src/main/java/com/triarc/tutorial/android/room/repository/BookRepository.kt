package com.triarc.tutorial.android.room.repository

import com.triarc.tutorial.android.room.contract.Book
import com.triarc.tutorial.android.room.storage.dao.BookDao
import java.util.regex.Pattern
import com.triarc.tutorial.android.room.entity.Book as BookEntity

/**
 * Created by Devanshu Verma on 13/1/19
 */
class BookRepository(private val bookDao: BookDao): Book.Repository {

     override fun saveBook(book: BookEntity) {
         bookDao.insert(book)
    }

    override fun deleteBook(book: BookEntity) {
        bookDao.delete(book)
    }

    override fun getExistingBooks(): List<BookEntity>? = bookDao.getAllBooks()

    override fun getBookByMatchingTitle(name: String): List<BookEntity>? {
        /*val sb = StringBuilder().append("(?:^|.*\\b)(")
        title.toUpperCase().forEach { sb.append(Pattern.quote(it.toString()) + "(?:\\p{Punct}|\\s)*?") }
        sb.append(").*")
        val nameRegex = sb.toString().toRegex()
        return bookDao.getAllBooks()?.filter { book ->
            //if(book == null)
            //    false

            book.title.toUpperCase().matches(nameRegex)
        }*/

        return bookDao.getBookByMatchingTitle(name)
    }
}
