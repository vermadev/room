package com.triarc.tutorial.android.room.base

import android.content.Context
import android.support.v4.app.FragmentActivity

/**
 * Created by Devanshu Verma on 13/1/19
 */
interface BaseView {
    fun getContext(): Context?
    fun getActivity(): FragmentActivity?
}
