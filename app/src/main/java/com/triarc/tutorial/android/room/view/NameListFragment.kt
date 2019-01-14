package com.triarc.tutorial.android.room.view

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.triarc.tutorial.android.room.MainActivity
import com.triarc.tutorial.android.room.R
import com.triarc.tutorial.android.room.adapter.NameListAdapter
import com.triarc.tutorial.android.room.application.RoomTutorialApplication
import com.triarc.tutorial.android.room.contract.UserList
import com.triarc.tutorial.android.room.entity.User
import kotlinx.android.synthetic.main.fragment_name_list.*
import javax.inject.Inject

/**
 * Created by Devanshu Verma on 13/1/19
 */
class NameListFragment: Fragment(), UserList.View {

    private var rootView: View? = null

    private var users: List<User>? = null

    private var nameListAdapter: NameListAdapter? = null

    private var recyclerLayoutManager: RecyclerView.LayoutManager? = null

    @Inject
    lateinit var presenter: UserList.Presenter

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        ((activity as? MainActivity)?.application as? RoomTutorialApplication)?.getApplicationComponent()?.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        rootView = inflater.inflate(R.layout.fragment_name_list, container, false)
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter.attachView(this)
    }

    override fun onResume() {
        super.onResume()

        presenter.getExistingUsers()
    }

    override fun onUserSaved() {
        input.text.clear()
    }

    override fun onInvalidInput(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun onUpdateView(users: List<User>?) {
        this.users = users
        nameListAdapter?.updateList(this.users)
    }

    override fun onInitialiseView() {
        recyclerLayoutManager = LinearLayoutManager(context)
        recycler_list_view.layoutManager = recyclerLayoutManager
        recycler_list_view.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
    }

    override fun onInitialiseAdapter() {
        nameListAdapter = NameListAdapter(users)
        recycler_list_view.adapter = nameListAdapter
    }

    override fun onInitialiseListener() {
        save.setOnClickListener {
            presenter.saveUser(input.text.toString())
        }
    }
}
