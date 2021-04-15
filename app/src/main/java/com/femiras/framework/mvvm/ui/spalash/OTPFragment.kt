package com.femiras.framework.mvvm.ui.spalash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.femiras.framework.mvvm.R
import com.femiras.framework.mvvm.extension.launchActivity
import com.femiras.framework.mvvm.ui.questions.QuestionsActivity
import kotlinx.android.synthetic.main.fragment_o_t_p.*


class OTPFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_o_t_p, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        backToTransactionButton.setOnClickListener{
            requireActivity().launchActivity<QuestionsActivity>()
            requireActivity().finish()


        }
    }
}