package com.triarc.tutorial.android.room.storage.dao

import android.arch.persistence.room.*
import com.triarc.tutorial.android.room.entity.User

/**
 * Created by Devanshu Verma on 14/1/19
 */
@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

    @Delete()
    fun delete(user: User)

    @Query("DELETE FROM User")
    fun deleteAll()

    @Update
    fun update(user: User)

    @Query("SELECT * FROM User ORDER BY timestamp DESC")
    fun getAllUsers(): List<User>?
}
