package com.triarc.tutorial.android.room.model

import com.triarc.tutorial.android.room.contract.User
import com.triarc.tutorial.android.room.entity.User as UserEntity

/**
 * Created by Devanshu Verma on 13/1/19
 */
class UserModel(private val repository: User.Repository): User.Model {

    override fun saveUser(user: UserEntity) {
        user.timestamp = System.currentTimeMillis()
        repository.saveUser(user)
    }

    override fun deleteUser(user: UserEntity) {
        repository.deleteUser(user)
    }

    override fun getExistingUsers(): List<UserEntity>? = repository.getExistingUsers()
}
