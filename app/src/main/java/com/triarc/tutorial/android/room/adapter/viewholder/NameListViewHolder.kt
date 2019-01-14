package com.triarc.tutorial.android.room.adapter.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.triarc.tutorial.android.room.R

/**
 * Created by Devanshu Verma on 13/1/19
 */
class NameListViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val name: TextView  = view.findViewById(R.id.name)
    val icon: ImageView = view.findViewById(R.id.icon)
}
