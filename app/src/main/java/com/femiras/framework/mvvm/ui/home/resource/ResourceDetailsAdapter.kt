package com.femiras.framework.mvvm.ui.home.resource

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.femiras.framework.mvvm.R
import com.femiras.framework.mvvm.ui.home.today.ThirdAdapter
import kotlinx.android.synthetic.main.layout_daily_news.view.*

class ResourceDetailsAdapter  (val context: Context,val resourceListener:ResourceListener) : RecyclerView.Adapter<ResourceDetailsAdapter.CustomViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val inflater = LayoutInflater.from(parent?.context)
        val cellForRow = inflater.inflate(R.layout.layout_resource_details, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {


        return 10
    }

    override fun onBindViewHolder(holder:CustomViewHolder, position: Int) {
        holder.itemView.setOnClickListener{
            resourceListener.onShow(1)
        }
//       when (position) {
//            1 ->
//                holder.itemView.icon.setImageResource(R.drawable.seconds)
//
//            2 ->    holder.itemView.icon.setImageResource(R.drawable.third)
//            3 ->    holder.itemView.icon.setImageResource(R.drawable.mood_swings)
//            4 ->    holder.itemView.icon.setImageResource(R.drawable.vitamins)
//            else ->    holder.itemView.icon.setImageResource(R.drawable.one)
//        }



//        Glide.with(context)
//                .load(product?.get(position)?.Picture)
//                .into( holder.itemView.img_icon!!)
//
//        var prices: String = ""
//        var quantity: String = ""
//
//        holder.itemView.tv_date.text = getStartDate(product?.get(position)?.Created)
//        holder.itemView.text_name.text = product?.get(position)?.Name
//        prices = "<b> <font color=#BF3E15>Price ট </font> : </b>" + product?.get(position)?.Price.toString()
//        quantity = "<b> <font color=#BF3E15>Quantity  </font> : </b>" + product?.get(position)?.Quantity.toString()
//        holder.itemView.tv_product_price.text = Html.fromHtml(prices!!)
//        holder.itemView.tv_quantity.text = Html.fromHtml(quantity!!)



    }

    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }
}