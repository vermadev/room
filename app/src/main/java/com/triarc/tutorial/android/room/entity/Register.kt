package com.triarc.tutorial.android.room.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

/**
 * Created by Devanshu Verma on 19/1/19
 */
@Entity(foreignKeys = [(ForeignKey(entity = User::class,
                        parentColumns = ["id"],
                        childColumns  = ["userId"],
                        onDelete = ForeignKey.CASCADE)),
                       (ForeignKey(entity = Book::class,
                        parentColumns = ["id"],
                        childColumns  = ["bookId"],
                        onDelete = ForeignKey.CASCADE))])
data class Register(var bookId: Int, var userId: Int): Serializable {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    var dueDate: Long? = null

    var issueDate: Long? = null
}
