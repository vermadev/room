package com.triarc.tutorial.android.room.model

import com.triarc.tutorial.android.room.contract.IssueBook
import com.triarc.tutorial.android.room.contract.User
import com.triarc.tutorial.android.room.contract.Register
import com.triarc.tutorial.android.room.entity.Entries
import com.triarc.tutorial.android.room.entity.Register as RegisterEntity
import com.triarc.tutorial.android.room.entity.User as UserEntity

/**
 * Created by Devanshu Verma on 30/1/19
 */
class IssueBookModel(private val user: User.Repository, private val register: Register.Repository): IssueBook.Model {

    override fun getUsers(): List<UserEntity>? = user.getExistingUsers()

    override fun addEntriesToRegister(entries: List<RegisterEntity>) {
        register.addEntriesToRegister(entries)
    }

    override fun getEntriesFromRegister(): List<Entries>? = register.getEntriesFromRegister()
}
