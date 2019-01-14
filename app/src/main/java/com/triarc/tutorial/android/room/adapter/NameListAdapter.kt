package com.triarc.tutorial.android.room.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.triarc.tutorial.android.room.R
import com.triarc.tutorial.android.room.adapter.viewholder.NameListViewHolder
import com.triarc.tutorial.android.room.entity.User

/**
 * Created by Devanshu Verma on 13/1/19
 */
class NameListAdapter(private var users: List<User>?): RecyclerView.Adapter<NameListViewHolder>()  {

    companion object ViewType {
        const val ITEM   = 1
        const val FOOTER = 2
    }

    fun updateList(users: List<User>?) {
        this.users = users
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = users?.size ?: 0

    override fun getItemViewType(position: Int): Int = if (users?.get(position) != null) ITEM else FOOTER

    override fun onBindViewHolder(viewHolder: NameListViewHolder, position: Int) {
        viewHolder.name.text = users?.get(position)?.name
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_name, parent, false)
        return NameListViewHolder(view)
    }
}
