package com.femiras.framework.mvvm.ui.home.resource

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.femiras.framework.mvvm.R
import kotlinx.android.synthetic.main.layout_resources_high.view.*

class ResourceHighAdapter (val context: Context) : RecyclerView.Adapter<ResourceHighAdapter.CustomViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val inflater = LayoutInflater.from(parent?.context)
        val cellForRow = inflater.inflate(R.layout.layout_resources_high, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {


        return 10
    }

    override fun onBindViewHolder(holder:CustomViewHolder, position: Int) {
        Glide.with(context)
            .load("https://www.globalblue.com/business/images/article926851.ece/BINARY/TFS_Article_2019_970x643.jpg")
            .into( holder.itemView.imageView4!!)



    }

    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }
}