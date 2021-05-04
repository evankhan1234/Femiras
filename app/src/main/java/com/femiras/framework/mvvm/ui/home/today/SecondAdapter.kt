package com.femiras.framework.mvvm.ui.home.today

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.femiras.framework.mvvm.R
import kotlinx.android.synthetic.main.layout_daily_news.view.*
import kotlinx.android.synthetic.main.layout_second.*
import kotlinx.android.synthetic.main.layout_second.view.*
import kotlinx.android.synthetic.main.layout_secret_chat_one.view.*

class SecondAdapter (val context: Context) : RecyclerView.Adapter<SecondAdapter.CustomViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val inflater = LayoutInflater.from(parent?.context)
        val cellForRow = inflater.inflate(R.layout.layout_second, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {


        return 5
    }

    override fun onBindViewHolder(holder:CustomViewHolder, position: Int) {

        Glide.with(context)
            .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRw4Xaf0afxbWT0zXRo6apRDS4y8jJPcM0dWg&usqp=CAU")
            .into( holder.itemView.icon!!)
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