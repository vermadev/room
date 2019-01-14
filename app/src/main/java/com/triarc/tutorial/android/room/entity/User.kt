package com.triarc.tutorial.android.room.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

/**
 * Created by Devanshu Verma on 14/1/19
 */
@Entity
data class User(var name: String): Serializable {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

    var timestamp: Long = 0
}