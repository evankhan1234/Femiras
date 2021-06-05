package com.femiras.framework.mvvm.ui.home.resource

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.femiras.framework.mvvm.R

import kotlinx.android.synthetic.main.layout_resources.view.*


class ResourceAdapter  (val context: Context,val resourceListener:ResourceListener) : RecyclerView.Adapter<ResourceAdapter.CustomViewHolder>() {

    var resourceHighAdapter: ResourceHighAdapter?=null
    var resourceLowAdapter: ResourceLowAdapter?=null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val inflater = LayoutInflater.from(parent?.context)
        val cellForRow = inflater.inflate(R.layout.layout_resources, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {


        return 6
    }

    override fun onBindViewHolder(holder:CustomViewHolder, position: Int) {
        when (position) {
            0 -> {
                holder.itemView.tv_text.text="Popular in Flo"
            }
            1 -> {
                holder.itemView.tv_text.text="Reproductive Health 101"
            }
            2 -> {
                holder.itemView.tv_text.text="Sex and Relationships"
            }
            3 -> {
                holder.itemView.tv_text.text="Your Nutrition and Health"
            }
            else -> {
                holder.itemView.tv_text.text="Undersatnding Your cycle"
            }
        }
        if(position==0){
            resourceHighAdapter = ResourceHighAdapter(context)
            holder.itemView.third_list?.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)

                adapter = resourceHighAdapter
            }
        }
        else{
            resourceLowAdapter = ResourceLowAdapter(context,resourceListener)
            holder.itemView.third_list?.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)

                adapter = resourceLowAdapter
            }
        }




    }

    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }
}