package com.triarc.tutorial.android.room.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.widget.Toolbar
import com.triarc.tutorial.android.room.R
import com.triarc.tutorial.android.room.base.AbstractBaseActivity
import com.triarc.tutorial.android.room.common.IntentKey
import com.triarc.tutorial.android.room.intf.ActivityCallback

/**
 * Created by Devanshu Verma on 15/1/19
 */
class BaseFragmentActivity: AbstractBaseActivity(), ActivityCallback {

    private var bundle: Bundle? = null
    private var actionBar: ActionBar? = null

    private lateinit var toolbar: Toolbar

    private var toolbarTitle: String? = null
    private var fragmentName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_base_fragment)

        initialiseIntentData(intent)

        initialiseToolbar()

        loadFragment(R.id.fragment_container, fragmentName, bundle)
    }

    override fun listener(fragmentName: String?, bundle: Bundle?) {
        loadFragment(R.id.fragment_container, fragmentName, bundle)
    }

    private fun initialiseToolbar() {
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        actionBar = supportActionBar
        actionBar?.let {
            it.setHomeButtonEnabled(true)
            it.setDisplayHomeAsUpEnabled(true)
        }

        toolbar.setNavigationOnClickListener { onBackPressed() }

        actionBar?.title = toolbarTitle
    }

    private fun initialiseIntentData(intent: Intent) {
        bundle = intent.extras

        fragmentName = intent.getStringExtra(IntentKey.FRAGMENT_NAME)
        toolbarTitle = intent.getStringExtra(IntentKey.TOOLBAR_TITLE)
    }
}
