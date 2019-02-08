package com.triarc.tutorial.android.room.storage.dao

import android.arch.persistence.room.*
import com.triarc.tutorial.android.room.entity.Book
import com.triarc.tutorial.android.room.entity.User

/**
 * Created by Devanshu Verma on 14/1/19
 */
@Dao
interface BookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(book: Book)

    @Delete()
    fun delete(book: Book)

    @Query("DELETE FROM Book")
    fun deleteAll()

    @Update
    fun update(book: Book)

    @Query("SELECT * FROM Book ORDER BY title ASC")
    fun getAllBooks(): List<Book>?

    @Query("SELECT * FROM Book WHERE title LIKE :title || '%' COLLATE NOCASE OR title LIKE '% ' || :title || '%' COLLATE NOCASE ORDER BY title ASC")
    fun getBookByMatchingTitle(title: String): List<Book>?
}
