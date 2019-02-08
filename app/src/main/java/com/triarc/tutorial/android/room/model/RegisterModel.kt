package com.triarc.tutorial.android.room.model

import com.triarc.tutorial.android.room.contract.Register
import com.triarc.tutorial.android.room.entity.Entries

/**
 * Created by Devanshu Verma on 16/1/19
 */
class RegisterModel(private val repository: Register.Repository): Register.Model {

    override fun getEntriesFromRegister(): List<Entries>? = repository.getEntriesFromRegister()
}