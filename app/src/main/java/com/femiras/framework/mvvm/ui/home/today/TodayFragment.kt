package com.femiras.framework.mvvm.ui.home.today

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.femiras.framework.mvvm.R



class TodayFragment : Fragment() {
    var firstAdapter: FirstAdapter?=null
    var secondAdapter: SecondAdapter?=null
    var listview: RecyclerView?=null
    var listview1: RecyclerView?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_today, container, false)
        listview=view.findViewById(R.id.listview)
        listview1=view.findViewById(R.id.listview1)
        listview?.isNestedScrollingEnabled=false
        listview1?.isNestedScrollingEnabled=false
        return view;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        firstAdapter = FirstAdapter(requireContext())
        secondAdapter = SecondAdapter(requireContext())
        listview?.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)

            adapter = firstAdapter
        }
        listview1?.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)

            adapter = secondAdapter
        }

    }
    companion object {
        @JvmStatic
        fun newInstance() = TodayFragment()
    }
}