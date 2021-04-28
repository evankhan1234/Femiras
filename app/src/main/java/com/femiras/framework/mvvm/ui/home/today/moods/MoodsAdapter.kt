package com.femiras.framework.mvvm.ui.home.today.moods

import android.content.Context
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.femiras.framework.mvvm.R
import kotlinx.android.synthetic.main.layout_moods.view.*

class MoodsAdapter (val context: Context) : RecyclerView.Adapter<MoodsAdapter.CustomViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val inflater = LayoutInflater.from(parent?.context)
        val cellForRow = inflater.inflate(R.layout.layout_moods, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {


        return 12
    }

    override fun onBindViewHolder(holder:CustomViewHolder, position: Int) {

       when (position) {
            0 ->
                Glide.with(context)
                    .load("https://s.abcnews.com/images/Entertainment/WireAP_8a696a69a427415c8e34e4a16555c1cd_16x9_992.jpg")
                    .into( holder.itemView.profile_image!!)


            1 ->       Glide.with(context)
                .load("https://static01.nyt.com/images/2020/04/19/multimedia/31parenting-NL-anxious/31parenting-NL-anxious-superJumbo.jpg")
                .into( holder.itemView.profile_image!!)
            2 ->       Glide.with(context)
                .load("https://cdn.tinybuddha.com/wp-content/uploads/2016/06/Cloud-head.png")
                .into( holder.itemView.profile_image!!)
           3 ->       Glide.with(context)
               .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgsIPBvy4_-2v5AsFMBnFYciMaW2fiEDNYrw&usqp=CAU")
               .into( holder.itemView.profile_image!!)
            4 ->       Glide.with(context)
                .load("https://i1.wp.com/www.worth.com/wp-content/uploads/2020/04/shutterstock_1186220500-scaled-e1587654507802.jpg?fit=1259%2C944&ssl=1")
                .into( holder.itemView.profile_image!!)
           5 ->       Glide.with(context)
               .load("https://images.herzindagi.info/image/2019/Apr/energetic-girl-wearing-red-dress.jpg")
               .into( holder.itemView.profile_image!!)
           6 ->       Glide.with(context)
               .load("https://cdn2.vectorstock.com/i/1000x1000/67/01/excited-woman-cartoon-character-vector-31086701.jpg")
               .into( holder.itemView.profile_image!!)
           7 ->       Glide.with(context)
               .load("https://www.hhs-consulting.com/wp-content/uploads/2020/06/hhs.png")
               .into( holder.itemView.profile_image!!)
            else ->       Glide.with(context)
                .load("https://s.abcnews.com/images/Entertainment/WireAP_8a696a69a427415c8e34e4a16555c1cd_16x9_992.jpg")
                .into( holder.itemView.profile_image!!)
        }


        when(position){
            0->
                holder.itemView.tv_text.text = "Angry"
            1->
                holder.itemView.tv_text.text = "Anxious"
            2->
                holder.itemView.tv_text.text = "Calm"
            3->
                holder.itemView.tv_text.text = "Depressed"
            4->
                holder.itemView.tv_text.text = "Emotional"
            5 ->
                holder.itemView.tv_text.text = "Energetic"
            6->
                holder.itemView.tv_text.text = "Excited"
            7->
                holder.itemView.tv_text.text = "Focused"
            else ->
                holder.itemView.tv_text.text = "Excited"


        }



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