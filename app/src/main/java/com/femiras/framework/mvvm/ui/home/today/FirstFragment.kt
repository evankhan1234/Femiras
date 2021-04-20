package com.femiras.framework.mvvm.ui.home.today

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.femiras.framework.mvvm.R
import kotlinx.android.synthetic.main.fragment_first.*


class FirstFragment : Fragment() {
    var firstAdapter: FirstAdapter?=null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        firstAdapter = FirstAdapter(requireContext())
        first_list?.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)

            adapter = firstAdapter
        }


    }
}