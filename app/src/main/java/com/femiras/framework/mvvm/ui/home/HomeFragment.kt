package com.femiras.framework.mvvm.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.femiras.framework.mvvm.R
import com.femiras.framework.mvvm.ui.questions.QuestionsOneFragmentDirections
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_o_t_p.*

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = HomePagerAdapter(childFragmentManager)
        pager.offscreenPageLimit = 1
        pager.adapter = adapter
        tabLayout.setupWithViewPager(pager)
        btnCalendar.setOnClickListener{
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToLogPeriodFragment(

                )
            )
        }
        fab.setOnClickListener{
            findNavController().navigate(
                    HomeFragmentDirections.actionHomeFragmentToLogFragment(

                    )
            )
        }

    }



}