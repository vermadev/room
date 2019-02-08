package com.triarc.tutorial.android.room.storage.dao

import android.arch.persistence.room.*
import com.triarc.tutorial.android.room.entity.Entries
import com.triarc.tutorial.android.room.entity.Register

/**
 * Created by Devanshu Verma on 14/1/19
 */
@Dao
interface RegisterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(register: Register)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg entries: Register)

    @Delete()
    fun delete(register: Register)

    @Query("DELETE FROM Register")
    fun deleteAll()

    @Update
    fun update(register: Register)

    @Query("SELECT r.id, r.dueDate, r.issueDate, u.name, u.email, b.title, b.author FROM User u INNER JOIN Register r ON u.id = r.userId INNER JOIN Book b ON r.bookId = b.id ORDER BY issueDate ASC")
    fun getRegisterEntries(): List<Entries>?
}
