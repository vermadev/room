package com.triarc.tutorial.android.room.model

import com.triarc.tutorial.android.room.contract.UserList
import com.triarc.tutorial.android.room.entity.User

/**
 * Created by Devanshu Verma on 13/1/19
 */
class UserListModel(private val repository: UserList.Repository): UserList.Model {

    override fun saveUser(user: User) {
        user.timestamp = System.currentTimeMillis()
        repository.saveUser(user)
    }

    override fun getUsers(): List<User>? = repository.getUsers()
}
