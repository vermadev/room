package com.triarc.tutorial.android.room.repository

import com.triarc.tutorial.android.room.contract.User
import com.triarc.tutorial.android.room.entity.User as UserEntity
import com.triarc.tutorial.android.room.storage.dao.UserDao

/**
 * Created by Devanshu Verma on 13/1/19
 */
class UserRepository(private val userDao: UserDao): User.Repository {

     override fun saveUser(user: UserEntity) {
        userDao.insert(user)
    }

    override fun deleteUser(user: UserEntity) {
        userDao.delete(user)
    }

    override fun getExistingUsers(): List<UserEntity>? = userDao.getAllUsers()
}
