package com.femiras.framework.mvvm.ui.home.questions

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.femiras.framework.mvvm.R
import com.femiras.framework.mvvm.ui.home.today.sex.SexListener
import com.tooltip.Tooltip
import kotlinx.android.synthetic.main.fragment_splash_screen.view.*
import kotlinx.android.synthetic.main.layout_question_poll.view.*
import kotlinx.android.synthetic.main.layout_resources_type.view.*


class QuestionsAdapter (val context: Context, val sexListener: SexListener) : RecyclerView.Adapter<QuestionsAdapter.CustomViewHolder>() {

    private  var mTooltip: Tooltip? =null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val cellForRow = inflater.inflate(R.layout.layout_question_poll, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {


        return 10
    }

    override fun onBindViewHolder(holder:CustomViewHolder, position: Int) {

        if (position==0 || position==2 || position==4){

            val rg = RadioGroup(context)


            for (i in 0..3){

                val radioButton = RadioButton(context)
                if(i==0){
                    radioButton.text = "Gym and Exerciise"
                }
                else if(i==1){
                    radioButton.text = "Follow Good Habit"
                }
                else if(i==2){
                    radioButton.text = "Eat Healthy Food and Nutrition"
                }
                else if(i==3){
                    radioButton.text = "Run Faster Like As Boult"
                }
                radioButton.background = context.resources.getDrawable(R.drawable.background_radio)
                radioButton.setButtonDrawable(context.getResources().getDrawable(android.R.color.transparent));
                radioButton.id=i
                val params = RadioGroup.LayoutParams(
                    RadioGroup.LayoutParams.MATCH_PARENT,
                    125
                )
                params.setMargins(25, 15, 15, 25)
                radioButton.setLayoutParams(params)
                radioButton.setPadding(40,0,0,0)
                radioButton.setTextColor(context.getResources().getColorStateList(R.color.selected));
                radioButton.setOnClickListener{
                    Log.e("dd","df"+radioButton.id )
                }

                rg.check(radioButton.id)
                rg.addView(radioButton, params)


            }
            holder.itemView.ll.addView(rg)
        }
        else{
            for (i in 0..5){
                val cb = CheckBox(context)
              //   cb.background = context.resources.getDrawable(R.drawable.rounded_button)
                 cb.setButtonDrawable(context.getResources().getDrawable(R.drawable.checkbox_selector))
                if(i==0){
                    cb.text = "Gym and Exerciise"
                }
                else if(i==1){
                    cb.text = "Follow Good Habit"
                }
                else if(i==2){
                    cb.text = "Eat Healthy Food and Nutrition"
                }
                else if(i==3){
                    cb.text = "Run Faster Like As Boult"
                }
                else if(i==4){
                    cb.text = "Listen to your body"
                }
                else if(i==5){
                    cb.text = "Music,Movies,Cooking and Drama"
                }
                cb.elevation=10f
                val params = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    60
                )
                cb.setPadding(20,0,0,0)
                params.setMargins(25, 15, 15, 25)
                holder.itemView.ll.addView(cb,params)

            }
        }


        holder.itemView.btn.setOnClickListener{ v->

            if (position==0 || position==3 || position==5){
                sexListener.onLoad("2")
            }
            else{
                sexListener.onLoad("1")
            }



        }
    }

    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}