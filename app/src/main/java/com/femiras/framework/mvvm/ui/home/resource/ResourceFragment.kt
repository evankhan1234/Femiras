package com.femiras.framework.mvvm.ui.home.resource

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.femiras.framework.mvvm.R
import kotlinx.android.synthetic.main.fragment_resource.*


class ResourceFragment : Fragment() ,ResourceListener{
    var resourceAdapter: ResourceAdapter?=null
    var resourceTypeAdapter: ResourceTypeAdapter?=null
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

        resourceAdapter = ResourceAdapter(requireContext(),this)
        third_list?.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
            adapter = resourceAdapter
        }
        resourceTypeAdapter = ResourceTypeAdapter(requireContext())
        second_list?.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
            adapter = resourceTypeAdapter
        }

    }

    override fun onShow(data: Int) {
        findNavController().navigate(
            ResourceFragmentDirections.actionMenuTvToMenuDetails()
        )

    }
}