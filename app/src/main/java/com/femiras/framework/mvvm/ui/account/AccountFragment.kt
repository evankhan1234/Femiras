package com.femiras.framework.mvvm.ui.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.femiras.framework.mvvm.R
import kotlinx.android.synthetic.main.fragment_account.*


class AccountFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val value: Float = java.lang.Float.valueOf("40")
        val value1: Float = java.lang.Float.valueOf("80")
      //  hpb.setPercent(value)
//        hpb1.setPercent(value1)
//        hpb1.test(0)
//        hpb.test(1)
//        hpb?.setOnClickListener{
//            hpb.setPercent(value)
//            hpb1.setPercent(value1)
//            hpb1.test(1)
//            hpb.test(0)
//        }
    }

}