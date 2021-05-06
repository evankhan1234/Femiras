package com.femiras.framework.mvvm.ui.chat

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.femiras.framework.mvvm.R
import com.femiras.framework.mvvm.ui.home.today.FirstAdapter
import com.femiras.framework.mvvm.ui.home.today.SecondAdapter
import kotlinx.android.synthetic.main.fragment_account.*
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.layout_poll.view.*
import kotlinx.android.synthetic.main.layout_secret_chat_one.view.*
import kotlinx.android.synthetic.main.layout_secret_chat_one.view.profile_image
import kotlinx.android.synthetic.main.layout_symtomps.view.*

class SecretChatAdapter (val context: Context) : RecyclerView.Adapter<SecretChatAdapter.CustomViewHolder>() {

    var suggestedProductAdapter: SuggestedProductAdapter?=null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val inflater = LayoutInflater.from(parent?.context)
        return if(viewType==1){
            val cellForRow = inflater.inflate(R.layout.layout_poll, parent, false)
            CustomViewHolder(cellForRow)
        }
        else {
            val cellForRow = inflater.inflate(R.layout.layout_secret_chat_one, parent, false)
            CustomViewHolder(cellForRow)
        }


    }

    override fun getItemCount(): Int {


        return 6
    }
    override fun getItemViewType(position: Int): Int {
        return if(position==1) {
           1
        }
        else if(position==3) {
            1
        }
        else if(position==5) {
            1
        }
        else{
           2
        }
    }
    override fun onBindViewHolder(holder:CustomViewHolder, position: Int) {

       if(holder.getItemViewType()==1){
            holder.itemView.item1.setOnClickListener {
                holder.itemView.test.visibility=View.VISIBLE
                holder.itemView.linear.visibility=View.GONE
                holder.itemView.hpb1.setPercent(20f)
                holder.itemView.hpb2.setPercent(60f)
                holder.itemView.hpb3.setPercent(90f)
                holder.itemView.hpb4.setPercent(40f)
                holder.itemView.hpb1.test(0,"Referrals")
                holder.itemView.hpb2.test(1,"Credential")
                holder.itemView.hpb3.test(1,"Experience")
                holder.itemView.hpb4.test(1,"All of Above")
            }
            holder.itemView.item2.setOnClickListener {
                holder.itemView.test.visibility=View.VISIBLE
                holder.itemView.linear.visibility=View.GONE
                holder.itemView.hpb1.setPercent(20f)
                holder.itemView.hpb2.setPercent(57f)
                holder.itemView.hpb3.setPercent(93f)
                holder.itemView.hpb4.setPercent(40f)
                holder.itemView.hpb1.test(1,"Referrals")
                holder.itemView.hpb2.test(0,"Credential")
                holder.itemView.hpb3.test(1,"Experience")
                holder.itemView.hpb4.test(1,"All of Above")
            }
            holder.itemView.item3.setOnClickListener {
                holder.itemView.test.visibility=View.VISIBLE
                holder.itemView.linear.visibility=View.GONE
                holder.itemView.hpb1.setPercent(20f)
                holder.itemView.hpb2.setPercent(43f)
                holder.itemView.hpb3.setPercent(90f)
                holder.itemView.hpb4.setPercent(40f)
                holder.itemView.hpb1.test(1,"Referrals")
                holder.itemView.hpb2.test(1,"Credential")
                holder.itemView.hpb3.test(0,"Experience")
                holder.itemView.hpb4.test(1,"All of Above")
            }
            holder.itemView.item4.setOnClickListener {
                holder.itemView.test.visibility=View.VISIBLE
                holder.itemView.linear.visibility=View.GONE
                holder.itemView.hpb1.setPercent(20f)
                holder.itemView.hpb2.setPercent(54f)
                holder.itemView.hpb3.setPercent(90f)
                holder.itemView.hpb4.setPercent(40f)
                holder.itemView.hpb1.test(1,"Referrals")
                holder.itemView.hpb2.test(1,"Credential")
                holder.itemView.hpb3.test(1,"Experience")
                holder.itemView.hpb4.test(0,"All of Above")
            }
        }else{
           if(position==2 || position==4) {
               holder.itemView.consider.visibility=View.GONE
           }

Glide.with(context)
                .load("https://i.pinimg.com/originals/af/8d/63/af8d63a477078732b79ff9d9fc60873f.jpg")
                .into( holder.itemView.imageView4!!)
            suggestedProductAdapter = SuggestedProductAdapter(context)
            holder.itemView.third_list?.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)

                adapter = suggestedProductAdapter
            }

        }



    }

    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }
}