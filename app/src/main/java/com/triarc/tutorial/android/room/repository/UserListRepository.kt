package com.triarc.tutorial.android.room.repository

import com.triarc.tutorial.android.room.contract.UserList
import com.triarc.tutorial.android.room.entity.User
import com.triarc.tutorial.android.room.storage.dao.UserDao

/**
 * Created by Devanshu Verma on 13/1/19
 */
class UserListRepository(private val userDao: UserDao): UserList.Repository {

     override fun saveUser(user: User) {
        userDao.insert(user)
    }

    override fun getUsers(): List<User>? = userDao.getAllUsers()
}
