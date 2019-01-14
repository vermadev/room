package com.triarc.tutorial.android.room.intf

/**
 * Created by Devanshu Verma on 13/1/19
 */
interface Logger {
    fun info(logMsg: String)
    fun error(logMsg: String)
    fun debug(logMsg: String)
}
