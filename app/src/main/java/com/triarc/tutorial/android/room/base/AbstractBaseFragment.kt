package com.triarc.tutorial.android.room.base

import android.content.Context
import android.support.v4.app.Fragment
import android.view.View
import com.triarc.tutorial.android.room.intf.Logger
import com.triarc.tutorial.android.room.logger.LoggerImpl

/**
 * Created by Devanshu Verma on 15/1/19
 */
abstract class AbstractBaseFragment: Fragment(), BaseView {

    protected val logger: Logger = LoggerImpl.getLogger(this)

    protected var rootView: View? = null

    override fun getContext(): Context? = activity
}
