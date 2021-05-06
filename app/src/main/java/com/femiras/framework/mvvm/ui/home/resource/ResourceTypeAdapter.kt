package com.femiras.framework.mvvm.ui.home.resource

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.femiras.framework.mvvm.R
import kotlinx.android.synthetic.main.layout_resources.view.*
import kotlinx.android.synthetic.main.layout_resources_type.view.*

class ResourceTypeAdapter (val context: Context) : RecyclerView.Adapter<ResourceTypeAdapter.CustomViewHolder>() {
    private var row_index = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val inflater = LayoutInflater.from(parent?.context)
        val cellForRow = inflater.inflate(R.layout.layout_resources_type, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {


        return 10
    }

    override fun onBindViewHolder(holder:CustomViewHolder, position: Int) {
        when (position) {
            0 -> {
                holder.itemView.type.text="Discover"
            }
            1 -> {
                holder.itemView.type.text="Saved"
            }
            2 -> {
                holder.itemView.type.text="Recent"
            }
            3 -> {
                holder.itemView.type.text="Watch"
            }
            else -> {
                holder.itemView.type.text="Discharge"
            }
        }
        holder.itemView.type.setOnClickListener { row_index=position;
            notifyDataSetChanged();  }
        if(row_index==position){
            holder.itemView.type.setBackground(context.getResources().getDrawable(R.drawable.background_res_color));
            holder.itemView.type.setTextColor(context.getResources().getColor(R.color.white));
        }
        else
        {
            holder.itemView.type.setBackground(context.getResources().getDrawable(R.drawable.background_res));
            holder.itemView.type.setTextColor(context.getResources().getColor(R.color.black));
        }


    }

    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }
}