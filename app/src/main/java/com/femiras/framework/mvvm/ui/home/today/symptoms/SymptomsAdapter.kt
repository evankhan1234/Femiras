package com.femiras.framework.mvvm.ui.home.today.symptoms

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.femiras.framework.mvvm.R
import kotlinx.android.synthetic.main.layout_symtomps.view.*

class SymptomsAdapter  (val context: Context) : RecyclerView.Adapter<SymptomsAdapter.CustomViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val inflater = LayoutInflater.from(parent?.context)
        val cellForRow = inflater.inflate(R.layout.layout_symtomps, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {


        return 12
    }

    override fun onBindViewHolder(holder:CustomViewHolder, position: Int) {

        when (position) {
            0 ->
                Glide.with(context)
                    .load("https://thumbs.dreamstime.com/b/beatiful-girl-acne-red-pimple-face-beatiful-girl-acne-red-pimple-face-teenager-ugly-skin-sad-female-153783027.jpg")
                    .into( holder.itemView.profile_image1!!)


            1 ->       Glide.with(context)
                .load("https://c8.alamy.com/comp/R1896N/illustration-of-a-kid-boy-in-front-of-a-meal-with-hands-on-face-and-no-appetite-R1896N.jpg")
                .into( holder.itemView.profile_image1!!)
            2 ->       Glide.with(context)
                .load("https://image.freepik.com/free-vector/out-line-business-woman-low-back-pain_81698-111.jpg")
                .into( holder.itemView.profile_image1!!)
            3 ->       Glide.with(context)
                .load("https://st4.depositphotos.com/23109214/31132/v/600/depositphotos_311322436-stock-illustration-young-woman-holding-midriff-facial.jpg")
                .into( holder.itemView.profile_image1!!)
            4 ->       Glide.with(context)
                .load("data:image/jpeg;base64,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")
                .into( holder.itemView.profile_image1!!)
            5 ->       Glide.with(context)
                .load("https://thumbs.dreamstime.com/b/woman-having-heart-attack-chest-pain-cartoon-vector-illustration-woman-having-heart-attack-chest-pain-cartoon-vector-123890618.jpg")
                .into( holder.itemView.profile_image1!!)
            6 ->       Glide.with(context)
                .load("data:image/jpeg;base64,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")
                .into( holder.itemView.profile_image1!!)
            7 ->       Glide.with(context)
                .load("https://w7.pngwing.com/pngs/503/870/png-transparent-dizziness-female-cartoon-others-thumbnail.png")
                .into( holder.itemView.profile_image1!!)
            else ->       Glide.with(context)
                .load("https://s.abcnews.com/images/Entertainment/WireAP_8a696a69a427415c8e34e4a16555c1cd_16x9_992.jpg")
                .into( holder.itemView.profile_image1!!)
        }


        when(position){
            0->
                holder.itemView.tv_text.text = "Acne"
            1->
                holder.itemView.tv_text.text = "Appetite"
            2->
                holder.itemView.tv_text.text = "Backache"
            3->
                holder.itemView.tv_text.text = "Bloating"
            4->
                holder.itemView.tv_text.text = "Constipation"
            5 ->
                holder.itemView.tv_text.text = "Cramps"
            6->
                holder.itemView.tv_text.text = "Diarrheea"
            7->
                holder.itemView.tv_text.text = "Diziness"
            else ->
                holder.itemView.tv_text.text = "Fatigue"


        }


    }

    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }
}