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

    private  var mPosition: Int? =0
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
                    mPosition=radioButton.id;
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
            if (position==0 || position==2 || position==4)
            {

                holder.itemView.ll.visibility=View.GONE
                holder.itemView.btn.visibility=View.GONE
                holder.itemView.ll1.visibility=View.VISIBLE
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
                    if(mPosition==i){
                        if (position==0){
                            sexListener.onLoad("2")
                            radioButton.background = context.resources.getDrawable(R.drawable.background_radio_red)
                            radioButton.setTextColor(context.getResources().getColorStateList(R.color.white))
                        }
                        else{
                            sexListener.onLoad("1")
                            radioButton.background = context.resources.getDrawable(R.drawable.background_radio_green)
                            radioButton.setTextColor(context.getResources().getColorStateList(R.color.white))
                        }

                    }
                    else{
                        radioButton.background = context.resources.getDrawable(R.drawable.background_radio_set)
                        radioButton.setTextColor(context.getResources().getColorStateList(R.color.colorPrimary));
                    }

                    radioButton.setButtonDrawable(context.getResources().getDrawable(android.R.color.transparent));
                    radioButton.id=i
                    val params = RadioGroup.LayoutParams(
                        RadioGroup.LayoutParams.MATCH_PARENT,
                        125
                    )
                    params.setMargins(25, 15, 15, 25)
                    radioButton.setLayoutParams(params)
                    radioButton.setPadding(40,0,0,0)
                    radioButton.setOnClickListener{
                        Log.e("dd","df"+radioButton.id )
                    }

                    rg.check(radioButton.id)

                    rg.addView(radioButton, params)


                }

                holder.itemView.ll1.addView(rg)
            }
            else{
                if(position==1){
                    sexListener.onLoad("1")
                }
                else{
                    sexListener.onLoad("2")
                }
                for (i in 0..5){
                    val cb = CheckBox(context)
                    //   cb.background = context.resources.getDrawable(R.drawable.rounded_button)

                    if(i==0){
                        cb.text = "Gym and Exerciise"
                        cb.setButtonDrawable(context.getResources().getDrawable(R.drawable.ic_checkbox))
                    }
                    else if(i==1){
                        cb.text = "Follow Good Habit"
                        cb.setButtonDrawable(context.getResources().getDrawable(R.drawable.ic_checkbox_2))
                    }
                    else if(i==2){
                        cb.text = "Eat Healthy Food and Nutrition"
                        cb.setButtonDrawable(context.getResources().getDrawable(R.drawable.ic_checkbox))
                    }
                    else if(i==3){
                        cb.text = "Run Faster Like As Boult"
                        cb.setButtonDrawable(context.getResources().getDrawable(R.drawable.background_radio))
                    }
                    else if(i==4){
                        cb.text = "Listen to your body"
                        cb.setButtonDrawable(context.getResources().getDrawable(R.drawable.ic_checkbox_2))
                    }
                    else if(i==5){
                        cb.text = "Music,Movies,Cooking and Drama"
                        cb.setButtonDrawable(context.getResources().getDrawable(R.drawable.ic_checkbox))
                    }
                    cb.elevation=10f
                    val params = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        60
                    )
                    cb.setPadding(20,0,0,0)
                    params.setMargins(25, 15, 15, 25)
                    holder.itemView.ll1.addView(cb,params)

                }

                holder.itemView.ll.visibility=View.GONE
                holder.itemView.btn.visibility=View.GONE
                holder.itemView.ll1.visibility=View.VISIBLE
            }



        }
    }

    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}