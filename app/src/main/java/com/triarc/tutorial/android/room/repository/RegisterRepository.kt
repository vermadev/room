package com.triarc.tutorial.android.room.repository

import com.triarc.tutorial.android.room.contract.Register
import com.triarc.tutorial.android.room.entity.Entries
import com.triarc.tutorial.android.room.storage.dao.RegisterDao
import com.triarc.tutorial.android.room.entity.Register as RegisterEntity

/**
 * Created by Devanshu Verma on 16/1/19
 */
class RegisterRepository(private val registerDao: RegisterDao): Register.Repository {

    override fun addEntryToRegister(register: RegisterEntity) {
        registerDao.insert(register)
    }

    override fun addEntriesToRegister(entries: List<RegisterEntity>) {
        registerDao.insert(*entries.toTypedArray())
    }

    override fun getEntriesFromRegister(): List<Entries>? = registerDao.getRegisterEntries()

    override fun deleteEntryFromRegister(register: RegisterEntity) {
        registerDao.delete(register)
    }

    override fun updateEntryFromRegister(register: RegisterEntity) {
        registerDao.update(register)
    }
}
