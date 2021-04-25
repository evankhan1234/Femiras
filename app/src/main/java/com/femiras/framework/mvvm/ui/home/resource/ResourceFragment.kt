package com.femiras.framework.mvvm.ui.home.resource

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.femiras.framework.mvvm.R
import com.femiras.framework.mvvm.ui.home.today.ThirdAdapter
import kotlinx.android.synthetic.main.fragment_resource.*


class ResourceFragment : Fragment() {
    var thirdAdapter: ThirdAdapter?=null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_resource, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = ResourceFragment()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        thirdAdapter = ThirdAdapter(requireContext())
        third_list?.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
            adapter = thirdAdapter
        }


    }
}