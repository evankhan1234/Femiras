package com.femiras.framework.mvvm.ui.home.questions

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.recyclerview.widget.RecyclerView
import com.femiras.framework.mvvm.R
import com.femiras.framework.mvvm.databinding.LayoutStressBinding
import com.femiras.framework.mvvm.ui.home.today.sex.SexListener
import com.tooltip.Tooltip
import kotlinx.android.synthetic.main.layout_question_poll.view.*


class QuestionsAdapter (val context: Context, val sexListener: SexListener) : RecyclerView.Adapter<QuestionsAdapter.CustomViewHolder>() {

    private  var mTooltip: Tooltip? =null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val inflater = LayoutInflater.from(parent?.context)
        val cellForRow = inflater.inflate(R.layout.layout_question_poll, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {


        return 10
    }

    override fun onBindViewHolder(holder:CustomViewHolder, position: Int) {

        if (position==0){

            val rg = RadioGroup(context)
            for (i in 0..4){

                val radioButton = RadioButton(context)
                radioButton.text = "Gym and Exerciise"
                radioButton.id=i
                val params = RadioGroup.LayoutParams(
                    RadioGroup.LayoutParams.WRAP_CONTENT,
                    RadioGroup.LayoutParams.WRAP_CONTENT
                )
                radioButton.setOnClickListener{
                    Log.e("dd","df"+radioButton.id )
                }
                rg.check(radioButton.id)
                rg.addView(radioButton, params)


            }
            holder.itemView.ll.addView(rg)
        }
        else{
            for (i in 1..5){
                val cb = CheckBox(context)
                cb.text = "Listen to your body"
                holder.itemView.ll.addView(cb)
            }
        }


        holder.itemView.btn.setOnClickListener{ v->

          sexListener.onLoad("1")


        }
    }

    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){


    }
}