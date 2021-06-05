package com.femiras.framework.mvvm.ui.home.resource

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.femiras.framework.mvvm.R
import kotlinx.android.synthetic.main.layout_resources_low.view.*

class ResourceLowAdapter (val context: Context,val resourceListener:ResourceListener) : RecyclerView.Adapter<ResourceLowAdapter.CustomViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val inflater = LayoutInflater.from(parent?.context)
        val cellForRow = inflater.inflate(R.layout.layout_resources_low, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {


        return 10
    }

    override fun onBindViewHolder(holder:CustomViewHolder, position: Int) {
        holder.itemView.setOnClickListener{
            resourceListener.onShow(1)
        }
        Glide.with(context)
            .load("https://thumbs.dreamstime.com/z/young-surprised-shocked-pregnant-woman-holding-positive-result-pregnancy-test-stress-disbelief-face-expression-unwan-126594701.jpg")
            .into( holder.itemView.imageView4!!)



    }

    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }
}