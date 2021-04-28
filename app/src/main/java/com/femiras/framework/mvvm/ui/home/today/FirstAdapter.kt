package com.femiras.framework.mvvm.ui.home.today

import android.content.Context
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.femiras.framework.mvvm.R
import com.femiras.framework.mvvm.ui.home.today.sex.SexListener

import kotlinx.android.synthetic.main.layout_first.*
import kotlinx.android.synthetic.main.layout_first.view.*
import kotlinx.android.synthetic.main.layout_moods.view.*

class FirstAdapter(val context: Context, val sexListener: SexListener) : RecyclerView.Adapter<FirstAdapter.CustomViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val inflater = LayoutInflater.from(parent?.context)
        val cellForRow = inflater.inflate(R.layout.layout_first, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {


        return 6
    }

    override fun onBindViewHolder(holder:CustomViewHolder, position: Int) {
         when (position) {
            1 ->  
                holder.itemView.icon.setImageResource(R.drawable.sleeping)

            2 ->    holder.itemView.icon.setImageResource(R.drawable.stress)
            3 ->    holder.itemView.icon.setImageResource(R.drawable.mood_swings)
            4 ->    holder.itemView.icon.setImageResource(R.drawable.vitamins)
            5 ->    Glide.with(context)
                .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRFh3B3oUtbZXot1CMdh1WLtwD84CcQ7jsfNQ&usqp=CAU")
                .into( holder.itemView.icon!!)
            else ->    holder.itemView.icon.setImageResource(R.drawable.sneeze)

        }
        when (position) {
            1 ->    holder.itemView.text.setText("Sex")
            2 ->    holder.itemView.text.setText("Stress")
            3 ->    holder.itemView.text.setText("Mood")
            4 ->    holder.itemView.text.setText("BBT")
            5 ->    holder.itemView.text.setText("Menstruation")
            else ->   holder.itemView.text.setText("Symptoms")
        }

        holder.itemView.setOnClickListener {
            when (position) {
                1 ->
                    sexListener.onLoad("Sex")

                2 ->     sexListener.onLoad("Stress")
                3 ->     sexListener.onLoad("Mood")
                4 ->     sexListener.onLoad("BBT")
                5 ->     sexListener.onLoad("Menstruation")
                else ->     sexListener.onLoad("Symptoms")

            }

        }


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